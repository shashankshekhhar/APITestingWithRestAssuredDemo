package specBuilder;

import org.apache.http.client.methods.RequestBuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BasicClass {

	
	public static RequestSpecification requestBuilder() {
		
		RequestSpecification reqBuilder= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON)
				.addQueryParam("key", "qaclick123").build();
			return 	reqBuilder;
		
	}
	
public static ResponseSpecification responseBuilder() {
		
	ResponseSpecification resBuilder= new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		return resBuilder;
	}
	
	
}
