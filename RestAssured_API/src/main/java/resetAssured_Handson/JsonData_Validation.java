package resetAssured_Handson;


import org.testng.annotations.Test;

import io.restassured.internal.ResponseSpecificationImpl.HamcrestAssertionClosure;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.TreeMap;

import static org.hamcrest.Matchers.equalTo;

public class JsonData_Validation {
	
	@Test(priority=1)
	public void singleContent() {
		
		TreeMap<String, String> data=new TreeMap<String,String>();
	
		 given()
		
		.when()
		.get("https://reqres.in/api/users")
		
		
		.then()
		.statusCode(200)
		.body(".data[5].email",equalTo("tracey.ramos@reqres.in"))
		.and()
		.log().all();
		
		
	
	}

}
