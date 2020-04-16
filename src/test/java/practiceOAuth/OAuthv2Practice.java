package practiceOAuth;

import org.junit.Test;

import basePackage.BaseClass;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuthv2Practice {

	@Test
	public void oauthtest() {

		/*given()
		.queryParam("auth_url", "https://accounts.google.com/o/oauth2/v2/auth")
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("response_type", "code")
		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("scope", "https://www.googleapis.com/auth/userinfo.email")
		.queryParam("state", "sas").
	
*/	
		
	//	https://rahulshettyacademy.com/getCourse.php?state=qqqqq&code=4%2FygGE7CVYlRQrTqauoD5jGEPq1zMgSdAhfaZkxuubz0IM-TPE40LMUZrRhsGbuhg-epDUoSOIPSFARODzOtKRAEE&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none#
		
		String code="4%2FygGE7CVYlRQrTqauoD5jGEPq1zMgSdAhfaZkxuubz0IM-TPE40LMUZrRhsGbuhg-epDUoSOIPSFARODzOtKRAEE";
			
		Response response=given().log().all()
		.queryParam("code", "4%2FygHOci8ez7W843WRmtEaoRsW84Ec5BubkymUSfcosfjfuvR3V0hh22BIEgUEoJhH5XGsaTMJTE0nx2guDE7w69g")
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grant_type", "authorization_code").when().post("https://www.googleapis.com/oauth2/v4/token").then()
		.assertThat().statusCode(200).extract().response();
		String accesToken=BaseClass.Jsonextracter(response, "access_token");
		
		given().queryParam("access_token", accesToken).when().get("https://rahulshettyacademy.com/getCourse.php").then()
		.log().all().assertThat().statusCode(200);
		
		
		
		
		
		
	}
}
