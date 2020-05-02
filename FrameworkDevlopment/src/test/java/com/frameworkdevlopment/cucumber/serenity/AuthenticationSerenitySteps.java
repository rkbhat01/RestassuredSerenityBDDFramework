package com.frameworkdevlopment.cucumber.serenity;

import com.frameworkdevlopment.testbase.TestBase;
import com.frameworkdevlopment.utils.ReuseableSpecifications;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class AuthenticationSerenitySteps extends TestBase {

	@Step("Auth Request with userName:{0}, password:{1}")
	public Response authrequest(String userName, String password) {
		RestAssured.baseURI="http://restapi.demoqa.com";
		
		Response response = SerenityRest.rest().given().spec(ReuseableSpecifications.getGenericRequestSpec()).auth().preemptive().basic(userName, password).when()
				.get("/authentication/CheckForAuthentication");
		
		response.then().log().all();
		
		return response;
	}
}
