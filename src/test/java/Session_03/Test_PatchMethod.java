package Session_03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PatchMethod {
	
	@Test
	public void test04() {
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Abbas");
		jsonData.put("job", "Auditor");
		
		RestAssured.baseURI = "https://reqres.in/api/users/98";
		RestAssured.given().header("Content-type", "Application/json").
		contentType(ContentType.JSON).
		body(jsonData.toJSONString()).
		when().
			patch().
		then().
			statusCode(200).
			log().all();
		
	}

}
