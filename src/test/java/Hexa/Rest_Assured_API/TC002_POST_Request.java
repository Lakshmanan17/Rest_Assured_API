package Hexa.Rest_Assured_API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
@Test
void Registrationsuccessful() {
	          //specify base URL
	
	RestAssured.baseURI="http://restapi.demoqa.com/customer";
	          //Request object
	
	RequestSpecification httpRequest=RestAssured.given();
	          //Request payload sending along with post request
	JSONObject requestparams=new JSONObject(); 
	requestparams.put("FirstName", "Lakshmanan");
	requestparams.put("LastName","Narayanan");
	requestparams.put("Username","Lakshmanan");
	requestparams.put("Password","Laksh@123");
	requestparams.put("Email","lakshmansuriya@gmail.com");
	
	httpRequest.header("Content-Type","application/json");
	httpRequest.body(requestparams.toJSONString());
	            //Response object
	
	Response response=httpRequest.request(Method.POST,"/register");
	            //Print response in console window
	String responsebody=response.getBody().asString();
	System.out.println("Response body is:"+responsebody);
	            //Status code validation
	int statuscode =response.getStatusCode();
	System.out.println("Statuscode is :" +statuscode);
	Assert.assertEquals(statuscode,201);
	           //Success code validation
	String successcode=response.jsonPath().get("SuccessCode");
	Assert.assertEquals(successcode,"Operationsuccess");
}
}
