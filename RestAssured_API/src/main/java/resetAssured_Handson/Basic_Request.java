package resetAssured_Handson;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;



public class Basic_Request {

	HashMap<String, String> data=new HashMap<String,String>();

	/*@Test(priority=1)
	public void getRequest() {	

	 given()
	.baseUri("https://reqres.in").basePath("/api/users?page=2")
	.when()
     .get()

	 .then()
	    .statusCode(200).log().all();
	}*/


	@Test(priority=2)
	public void postRequest() {

		data.put("name", "vinod");
		data.put("job", "Tester");



		given()
		.baseUri("https://reqres.in").basePath("/api/users")
		.contentType("application/json")
		.body(data)

		.when()
		.post()

		.then()
		.statusCode(201)
		.statusLine("HTTP/1.1 201 Created")
		.and()
		.log().all()
		.body("name",equalTo("vinod"))
		.body("job", equalTo("Tester"));



	}

	@Test(priority=3)
	public void putRequest() {

		data.put("fitst_name", "vino");
		data.put("last_name", "chenu");
		data.put("email", "vinoalphaq@gmail.com");
		
		
        Response response=
		given()

		.baseUri("https://reqres.in").basePath("/api/users/3")
		.body(data)


		.when()
		.put()

		.then()
		.statusCode(200)
		.log().all()

		.and()
		.body("first_name", equalTo("vino"))
		.body("last_name", equalTo("chenu"))
		.body("email", equalTo("vinoalphaq@gmail.com"))
		.extract().response();
        
        String totalresponse=response.asString();
        
        Assert.assertEquals(totalresponse.contains("deleted"),true);


	}

/*	@Test(priority=4)
	public void deleteRequest() {

		given()
		.baseUri("https://reqres.in").basePath("/api/users/2")

		.when()
		.delete()

		.then()
		.statusCode(204)
		.statusLine("HTTP/1.1 204 No Content")
		.log().all();

	}*/

}
