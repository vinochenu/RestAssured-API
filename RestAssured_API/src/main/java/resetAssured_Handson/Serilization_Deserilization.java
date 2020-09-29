package resetAssured_Handson;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;



//To avoid unrecognized property exception, we avoid setter method in pojo class & give string input as raw body in serilization method &
//use MapperObject class(JACKSON Lib) with readvalue method for deserilization 

public class Serilization_Deserilization {
	
	
	String input;
	
	//Serilization
	@Test(priority=1)
	public void postSerilization() {
	
	/*REQRESPojo reqresPojo=reqresPojo=new REQRESPojo();
	
	reqresPojo.setId(100);
	reqresPojo.setEmail("vinoalphaq@gmail.com");
	reqresPojo.setFirst_name("vino");
	reqresPojo.setLast_name("chenu");
	reqresPojo.setAvatar("https://www.google.com/search?q=fis&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiyoIaX787rAhXymuYKHYhyDngQ_AUoAnoECBsQBA#imgrc=vwlibl3vOpq7EM");
	*/
	 
	  input="{\r\n" + 
	 		"            \"id\": 100,\r\n" + 
	 		"            \"email\": \"vino@gmail.com\",\r\n" + 
	 		"            \"first_name\": \"vinu\",\r\n" + 
	 		"            \"last_name\": \"chinu\",\r\n" + 
	 		"            \"avatar\": \"https://www.google.com/search?q=google&source=lnms&tbm=isch&sa=X&ved=2ahUKEwil56uggM_rAhWTILcAHdFBBNkQ_AUoBHoECCAQBg&biw=1366&bih=657#imgrc=mS-O6pg_QD7OxM\"\r\n" + 
	 		"        }";
	
	given()
	.baseUri("https://reqres.in").basePath("/api/users")
	.contentType(ContentType.JSON)
	.body(input)
	
	.when()
	.post()
	
	.then()
	.statusCode(201)
	.log().all();
	
}
	
	
	//Deserilization
	@Test(priority=2)
	public void getDeserilization() throws JsonParseException, JsonMappingException, IOException {
		
		
		/*REQRESPojo reqresPojo1=get("https://reqres.in/api/users").as(REQRESPojo.class);
		String response=reqresPojo1.getResponse();
		System.out.println("Response after deserilization is "+response);
		int actualid=reqresPojo1.getId();
		Assert.assertEquals(actualid, 100);*/
		
		ObjectMapper mapper=new ObjectMapper();
		REQRESPojo details=mapper.readValue(input, REQRESPojo.class);
		
		System.out.println(details.getResponse());
		Assert.assertEquals(details.getId(), 100);
		
		
	}
	
}