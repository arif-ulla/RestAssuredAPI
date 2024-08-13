package Session_03;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Test_GetMethod {
	
	// Using RestAssured	
	@Test
	public void test01() {
		Response res = get("https://reqres.in/api/users?page=2");
		System.out.println("Response Code: " + res.getStatusCode());
		System.out.println("Response Body: " + res.getBody().asString());
		System.out.println("Response Header_Date: " + res.getHeader("Date"));
		System.out.println("Response Time: " + res.getTime());
		System.out.println("Response Header_Content-Type: " + res.getHeader("Content-Type"));
		
		// Validate Status-Code
		int expectedStatusCode = 200;
		int actualStatusCode = res.getStatusCode();
		
		Assert.assertEquals(expectedStatusCode, actualStatusCode);
	}	
	
	// Using RestAssured BDD Style
	@Test
	public void test02() {
		//given, when, then
		baseURI = "https://reqres.in/api/users";
		given().queryParam("page", "2")
		.when().get()
		.then().statusCode(200);	
	}

}
