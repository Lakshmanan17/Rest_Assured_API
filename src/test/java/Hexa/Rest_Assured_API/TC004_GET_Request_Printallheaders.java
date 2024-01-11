package Hexa.Rest_Assured_API;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Request_Printallheaders {
	@Test
	public void getweatherdetails() {
		   //specify base URL
		
				RestAssured.baseURI="http://maps.googleapis.com";
				          //Request object
				
				RequestSpecification httpRequest=RestAssured.given();
			             //Response object
				
				Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location");
				         //Print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("Response Body is :" +responsebody);
				
				Headers allheaders=response.headers();//capture all the headers				
				for(Header headers: allheaders)
				{
					System.out.println(headers.getName()+""+headers.getValue());
				}
}
}