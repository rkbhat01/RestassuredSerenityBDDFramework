package com.frameworkdevlopment.cucumber.serenity;

import com.frameworkdevlopment.model.CustomerClass;
import com.frameworkdevlopment.utils.ReuseableSpecifications;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CustomerRegisterSerenitySteps {

	@Step("Customer Registration Request with FirstName:{0}, LastName:{1},UserName:{2},Password:{3}, Email:{4}")
	public Response registerCustomer(String FirstName, String LastName, String UserName, String Password, String Email) {
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		CustomerClass cst = new CustomerClass();
		cst.setFirstName(FirstName);
		cst.setLastName(LastName);
		cst.setUserName(UserName);
		cst.setPassword(Password);
		cst.setEmail(Email);
	
		Response response = SerenityRest.rest().given()
	  .spec(ReuseableSpecifications.getGenericRequestSpec())
	  .log()
	  .all()
	  .when()
	  .body(cst)
	  .post("/register");
		response.then().log().all();
		
		return response;
	}
}
