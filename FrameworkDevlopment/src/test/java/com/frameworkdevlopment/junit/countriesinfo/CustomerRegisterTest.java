package com.frameworkdevlopment.junit.countriesinfo;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.frameworkdevlopment.cucumber.serenity.CustomerRegisterSerenitySteps;
import com.frameworkdevlopment.model.CustomerClass;
import com.frameworkdevlopment.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;

import com.frameworkdevlopment.utils.TestUtils;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CustomerRegisterTest extends TestBase  {
	
	
	@Steps
	CustomerRegisterSerenitySteps steps;
	
	String jsonString;
	static String FirstName = "SMOKEUSER" +TestUtils.getRandomValue(); 
	static String LastName = "SMOKEUSER" +TestUtils.getRandomValue(); 
	static String UserName = "SMOKEUNAME"+TestUtils.getRandomValue();
	static String Email =  TestUtils.getRandomValue()+ "xyz@gmail.com"; 
	static String Password = "password1";
	
	@WithTag("Customer")
	@Title("This test will register customer")
	@Test
	public void test01() {
		
		
		Response response = steps.registerCustomer(FirstName,LastName,UserName,Password,Email);

		Assert.assertEquals(response.getStatusCode(),201);
		Assert.assertEquals(response.jsonPath().get("SuccessCode"),"OPERATION_SUCCESS");
		Assert.assertTrue(response.getBody().asString().contains("Operation completed successfully"));
	}
	
	@WithTag("Customer")
	@Title("This test verify valid error message for POST request with existing user details")
	@Test
	public void test02() {
		
		Response response = steps.registerCustomer(FirstName,LastName,UserName,Password,Email);

		Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertEquals(response.jsonPath().get("fault"),"FAULT_USER_ALREADY_EXISTS");
	}

}
