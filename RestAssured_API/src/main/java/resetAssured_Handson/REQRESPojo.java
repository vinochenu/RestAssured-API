package resetAssured_Handson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class REQRESPojo {
	@JsonProperty
	private int id;
	@JsonProperty
	private String email;
	@JsonProperty
	private String first_name;
	@JsonProperty
	private String last_name;
	@JsonProperty
	private String avatar;
	@JsonProperty
	private String response;
	
	
	public int getId() {
		return id;
	}
	/*public void setId(int id) {
		this.id = id;
	}*/
	public String getEmail() {
		return email;
	}
	/*public void setEmail(String email) {
		this.email = email;
	}*/
	public String getFirst_name() {
		return first_name;
	}
	/*public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}*/
	public String getLast_name() {
		return last_name;
	}
	/*public void setLast_name(String last_name) {
		this.last_name = last_name;
	}*/
	public String getAvatar() {
		return avatar;
	}
	/*public void setAvatar(String avatar) {
		this.avatar = avatar;
	}*/
	public String getResponse() {
		System.out.println("Response is "+"ID is "+getId()+" "+"EMAIL is "+getEmail()+" "+"FIRSTNAME is "+getFirst_name()+" "+"LASTNAME is "+getLast_name()+" "+"AVATAR is "+getAvatar());
		return response;
	}
	
	/*public void setResponse(String response) {
		this.response=response;
		
	}*/

	

}
