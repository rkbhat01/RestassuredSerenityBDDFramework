package com.frameworkdevlopment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerClass {
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	private String Email;
	
	@JsonProperty("FirstName")
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	@JsonProperty("LastName")
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	@JsonProperty("UserName")
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	@JsonProperty("Password")
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	@JsonProperty("Email")
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	
}
