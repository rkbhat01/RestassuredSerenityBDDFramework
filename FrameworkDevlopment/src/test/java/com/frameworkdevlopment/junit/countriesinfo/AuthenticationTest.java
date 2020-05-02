package com.frameworkdevlopment.junit.countriesinfo;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.frameworkdevlopment.cucumber.serenity.AuthenticationSerenitySteps;
import com.frameworkdevlopment.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AuthenticationTest extends TestBase  {

	@Steps
	AuthenticationSerenitySteps step;
	
	@WithTag("Auth")
	@Title("This test validate login authentication with valid entries")
	@Test
	public void test01() {
		
		Response response = step.authrequest("ToolsQA", "TestPassword");
		
		Assert.assertEquals(200,response.getStatusCode());
		Assert.assertEquals("OPERATION_SUCCESS",response.jsonPath().get("FaultId"));
	}
	
	@WithTag("Auth")
	@Title("This test verify valid error message for invalid credentials")
	@Test
	public void test02() {
		
		Response response = step.authrequest("ToolsQA", "1TestPassword");
		
		Assert.assertEquals(401,response.getStatusCode());
		Assert.assertEquals("FAULT_USER_INVALID_USER_PASSWORD",response.jsonPath().get("FaultId"));
	}
}
