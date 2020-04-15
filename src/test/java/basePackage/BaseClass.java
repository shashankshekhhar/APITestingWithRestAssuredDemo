package basePackage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class BaseClass {

	
	public static String Jsonextracter(Response response, String Field) {
		JsonPath json= new JsonPath(response.asString());
		
		return json.getString(Field);
		
	}
	
	
	
	public static String GenerateStringFromResource(String path) throws IOException {
		
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
