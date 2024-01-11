package Hexa.Rest_Assured_API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_Datadriven_with_Dataprovider {
	@Test(dataProvider="empdataprovider")
	void postnewEmployees(String ename,String esal,String eage )
	{
                  //specify base URL
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		          //Request object
		
		RequestSpecification httpRequest=RestAssured.given();
		           //Request payload sending along with post request
		JSONObject requestparams=new JSONObject(); 
		requestparams.put("name", ename);
		requestparams.put("salary",esal);
		requestparams.put("age",eage);
		            //Add a header stating the requestbody is a json
		httpRequest.header("Content-Type","application/json");
		            //Add the Json to the body of the request
		httpRequest.body(requestparams.toJSONString());
		           //Post Request
		Response response=httpRequest.request(Method.POST,"/create");
		          //capture response body to perform validations
		String responseBody=response.getBody().asString();
		System.out.println(" Eresponse body is:"+responseBody);
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(esal), true);
		Assert.assertEquals(responseBody.contains(eage), true);
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	@DataProvider(name="empdataprovider")
	String[][] getempdata(){
		String empdata[][]= {{"laksh","1000","36"},{"lax","2000","36"},{"lakshmi","3000","36"}}; 
		return(empdata);
	}
	
}
