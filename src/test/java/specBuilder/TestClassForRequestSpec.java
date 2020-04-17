package specBuilder;

import org.junit.Test;

import BDD.APITestProjectDemo.payload;

import static io.restassured.RestAssured.*;

public class TestClassForRequestSpec {

	@Test
	public void Test1() {

		given().spec(BasicClass.requestBuilder()).log().all().body(payload.addPayload()).when()
				.post("/maps/api/place/add/json").then().log().all().spec(BasicClass.responseBuilder()).extract()
				.response();

	}
}
