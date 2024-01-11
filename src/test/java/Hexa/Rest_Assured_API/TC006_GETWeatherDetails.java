package Hexa.Rest_Assured_API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GETWeatherDetails {
	@Test
	void getweatherdetails() {
		           //specify base URL
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		          //Request object
		
		RequestSpecification httpRequest=RestAssured.given();
	             //Response object
		
		Response response=httpRequest.request(Method.GET,"/Delhi");
		JsonPath jsonpath=response.jsonPath();
		System.out.println(jsonpath.get("City"));
		System.out.println(jsonpath.get("Temperature"));
		System.out.println(jsonpath.get("Humidity"));
		System.out.println(jsonpath.get("Weather description"));
		System.out.println(jsonpath.get("Wind speed"));
		System.out.println(jsonpath.get("Wind direction degree"));
		
		Assert.assertEquals(jsonpath.get("Temperature"), "39 degree celcius");
}
}