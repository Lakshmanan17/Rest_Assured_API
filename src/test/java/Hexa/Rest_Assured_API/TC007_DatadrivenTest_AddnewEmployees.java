package Hexa.Rest_Assured_API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_DatadrivenTest_AddnewEmployees {

	@Test
	void postnewEmployees()
	{
                  //specify base URL
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		          //Request object
		
		RequestSpecification httpRequest=RestAssured.given();
		           //Request payload sending along with post request
		JSONObject requestparams=new JSONObject(); 
		requestparams.put("name", "Laksh");
		requestparams.put("salary","15000");
		requestparams.put("age","36");
		            //Add a header stating the requestbody is a json
		httpRequest.header("Content-Type","application/json");
		            //Add the Json to the body of the request
		httpRequest.body(requestparams.toJSONString());
		           //Post Request
		Response response=httpRequest.request(Method.POST,"/create");
		          //capture response body to perform validations
		String responseBody=response.getBody().asString();
		Assert.assertEquals(responseBody.contains("Laksh"), true);
		Assert.assertEquals(responseBody.contains("15000"), true);
		Assert.assertEquals(responseBody.contains("36"), true);
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	
}
