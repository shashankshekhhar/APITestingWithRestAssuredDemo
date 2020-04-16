package serializationDeserialization;

import org.junit.Test;

import basePackage.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;
import pojoClassesLocations.Addplace;
import pojoClassesLocations.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class TestAddLocation {

	@Test
	public void testcase1() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		Addplace addplace = new Addplace();
		Location location = new Location();
		location.setLat("1212121");
		location.setLng("000000");
		ArrayList<String> abc = new ArrayList();
		abc.add("Shoe");
		abc.add("Shawl");

		addplace.setAccuracy(50);
		addplace.setAddress("Noida India");
		addplace.setLanguage("English");
		addplace.setLocation(location);
		addplace.setName("SHshs");
		addplace.setPhone_number("102010202");
		addplace.setTypes(abc);

		Response res=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(addplace)
				.when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).extract().response();

		
	}
}
