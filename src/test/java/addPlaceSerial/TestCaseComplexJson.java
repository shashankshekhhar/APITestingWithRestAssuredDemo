package addPlaceSerial;

import org.junit.Test;

import basePackage.BaseClass;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import pojoClasses.GetCourses;

import static io.restassured.RestAssured.*;


public class TestCaseComplexJson {

	
	@Test
	public void complexJsondeserialization() {
	
		
		RestAssured.baseURI="";
		
		//Directly consuming Accestoken Refer OAuthClass
		String accesToken="ya29.a0Ae4lvC02DrTygE1yjipzZnYUbVXo05b2tTRCGHACeMZC8w_3SG5uBd-N6b5XvsVxpYMXnVeabVdgClvjH2bwL6NKza-K7r1iJ5iK9H2EpUG1n18UI6nrpXpwqcAS1EenM8BmjP4FJLwuxUcbmJQ1c0bCXzdA_43iHcoJ";
		
		
		//Deserialization
	
		GetCourses gc=given().queryParam("access_token", accesToken).header("Content-Type","application/json").expect().defaultParser(Parser.JSON).when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourses.class);
	
	System.out.println(gc.getCourses().getApi().get(0).getCourseTitle());
	
	
	
	}
	
}
