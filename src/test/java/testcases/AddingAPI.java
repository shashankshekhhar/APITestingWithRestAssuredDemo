package testcases;
import io.restassured.*;
import org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.junit.Test;

import BDD.APITestProjectDemo.payload;

public class AddingAPI {

	 @Test
	public void addplacetest() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(payload.addPayload()).when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
		.header("connection","Keep-Alive");
		
		
		
	}
	
}
