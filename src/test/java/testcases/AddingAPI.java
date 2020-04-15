package testcases;
import io.restassured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import BDD.APITestProjectDemo.payload;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddingAPI {

	static String placeid;
	 @Test
	public void addplacetest() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(payload.addPayload()).when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
		.header("connection","Keep-Alive").extract().response();
		
		JsonPath js= new JsonPath(response.asString());
		
		placeid=js.getString("place_id");
		
		
	}
	 @Test()
	public void putApitest() {
		 RestAssured.baseURI="https://rahulshettyacademy.com";
		 
		Response response =given().log().all().queryParam("key", "qaclick123").body("{\r\n" + 
		 		"\"place_id\":\""+placeid+"\",\r\n" + 
		 		"\"address\":\"Lodfi GArden, USA\",\r\n" + 
		 		"\"key\":\"qaclick123\"\r\n" + 
		 		"}\r\n" + 
		 		"").header("Content-Type","application/json").when().put("/maps/api/place/update/json").then().log().all().statusCode(200).extract().response();
		
		JsonPath js= new JsonPath(response.asString());
		System.err.println(js.get("msg"));
		
	}
	 @Test
	 public void sgetAPiTest() {
		 
		 RestAssured.baseURI="https://rahulshettyacademy.com";
		 
		Response response= given().header("Content-Type","application/json").queryParam("key", "qaclick123").queryParam("place_id", placeid).log().all()
		 .when().get("/maps/api/place/get/json").then().assertThat().statusCode(200).extract().response();
	
	 JsonPath jss= new JsonPath(response.asString());
	 Assert.assertEquals(jss.get("address"), "Lodfi GArden, USA");
		System.out.println(response.asString());
	 
	 }
	 
	 @Test
	 public void tdeleteAPiTest() {
		 
		 RestAssured.baseURI="https://rahulshettyacademy.com";
		 
		Response response= given().header("Content-Type","application/json").queryParam("key", "qaclick123").queryParam("place_id", placeid).body("{\r\n" + 
				"    \"place_id\":\""+placeid+"\"\r\n" + 
				"}\r\n" + 
				"").log().all()
		 .when().delete("/maps/api/place/delete/json").then().assertThat().statusCode(200).extract().response();
	
		 JsonPath jss= new JsonPath(response.asString());
		Assert.assertEquals(jss.getString("status"), "OK");
	 
	 }
	 
}
