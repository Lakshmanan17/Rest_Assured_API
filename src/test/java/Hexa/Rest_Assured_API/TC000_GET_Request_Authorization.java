package Hexa.Rest_Assured_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC000_GET_Request_Authorization {

	@Test
	public void Autherizationtest() {
		    //specify base url
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		RestAssured.authentication=authscheme;
		
                 //Request object		
		RequestSpecification httpRequest=RestAssured.given();
	             //Response object
		
		Response response=httpRequest.request(Method.GET,"/");
		          //Print response in console window
		String responsebody=response.getBody().asString();
		System.out.println("Response Body is :" +responsebody);
		               //status code validation
				int statuscode =response.getStatusCode();
				System.out.println("Statuscode is :" +statuscode);
				Assert.assertEquals(statuscode,200);
				
	}
}
