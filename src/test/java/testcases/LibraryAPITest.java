package testcases;

import org.junit.Test;

import BDD.APITestProjectDemo.payload;
import basePackage.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import org.hamcrest.*;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class LibraryAPITest {

	private String ID;
	
	@Test
	public void addbookTest() {
		
		RestAssured.baseURI="http://216.10.245.166";
	Response response=given().header("Content-Type","application/json").body(payload.addBookPayload()).when()
		.post("Library/Addbook.php").then().assertThat().statusCode(200).extract().response();
		ID=BaseClass.Jsonextracter(response, "ID");
	Assert.assertEquals("successfully added", BaseClass.Jsonextracter(response, "Msg"));
		
	}
	
	
	//FromExternalJSonFile
	@Test
	public void addbookTest1() throws IOException {
		
		RestAssured.baseURI="http://216.10.245.166";
	Response response=given().header("Content-Type","application/json").body(BaseClass.GenerateStringFromResource("D:\\ApiTestingFramework\\APITestProjectDemo\\Addbook.json")).when()
		.post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response();
		ID=BaseClass.Jsonextracter(response, "ID");
	Assert.assertEquals("successfully added", BaseClass.Jsonextracter(response, "Msg"));
		
	}
	
}
