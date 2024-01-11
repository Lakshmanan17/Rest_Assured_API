package Hexa.Rest_Assured_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_validation_JSON_response {
	@Test
	void getweatherdetails() {
		           //specify base URL
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		          //Request object
		
		RequestSpecification httpRequest=RestAssured.given();
	             //Response object
		
		Response response=httpRequest.request(Method.GET,"/Chennai");
		        //Print response in console window
		String responsebody=response.getBody().asString();
		System.out.println("Response Body is :" +responsebody);
		Assert.assertEquals(responsebody.contains("Chennai"), true);
		
}
}