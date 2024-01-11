package Hexa.Rest_Assured_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	void getweatherdetails() {
		           //specify base URL
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		          //Request object
		
		RequestSpecification httpRequest=RestAssured.given();
	             //Response object
		
		Response response=httpRequest.request(Method.GET,"hyderabad");
		        //Print response in console window
		String responsebody=response.getBody().asString();
		System.out.println("Response Body is :" +responsebody);
		
		        //status code validation
		int statuscode =response.getStatusCode();
		System.out.println("Statuscode is :" +statuscode);
		Assert.assertEquals(statuscode,200);
		
		        //Status line verification
		String statusline=response.getStatusLine();
		System.out.println("statusline is:"+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 ok");
	}

}
