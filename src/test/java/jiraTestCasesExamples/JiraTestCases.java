package jiraTestCasesExamples;

import org.junit.Test;

import basePackage.BaseClass;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.io.File;

public class JiraTestCases {

	@Test
	public void loginJiraTest() {

		RestAssured.baseURI = "http://localhost:8080";

		SessionFilter session = new SessionFilter();
		given().header("Content-Type", "application/json")
				.body("{ \"username\": \"username1\", \"password\": \"password1\" }")

				.filter(session).when().post("/rest/auth/1/session").then().assertThat().statusCode(200).log().all()
				.extract().response();

		/// Adding A Comment to Issue
		Response response = given().log().all().header("Content-Type", "application/json").filter(session)
				.pathParam("issueID", 10002)
				.body("{\r\n" + "    \"body\": \"NewCommentAdded\",\r\n" + "    \"visibility\": {\r\n"
						+ "        \"type\": \"role\",\r\n" + "        \"value\": \"Administrators\"\r\n" + "    }\r\n"
						+ "}")
				.when().post("/rest/api/2/issue/{issueID}/comment").then().log().all().assertThat().statusCode(201)
				.extract().response();
		JsonPath js = new JsonPath(response.asString());
		String commentID = js.getString("id");
		System.out.println(commentID);

		// Adding Attachement
		given().log().all().filter(session).header("X-Atlassian-Token", "no-check").pathParam("issueId", "10002")
				.multiPart("file", new File("D:\\ApiTestingFramework\\APITestProjectDemo\\ABC.txt")).when()
				.post("/rest/api/2/issue/{issueId}/attachments").then().assertThat().statusCode(200);

		Response res = given().filter(session).pathParam("issueId", "10002").queryParam("fields", "project", "comment")
				.when().get("/rest/api/2/issue/{issueId}").then().log().all().assertThat().statusCode(200).extract()
				.response();
		JsonPath jss = new JsonPath(res.asString());

		int totalComments = jss.getInt("fields.comment.comments.size()");
		System.err.println(totalComments);

		for (int i = 0; i < totalComments; i++) {

			if (jss.getString("fields.comment.comments[" + i + "].id").equalsIgnoreCase(commentID)) {
				System.err.println(jss.getString("fields.comment.comments[" + i + "].body"));

				Assert.assertEquals("NewCommentAdded", jss.getString("fields.comment.comments[" + i + "].body"));
			}
		}

	}
}
