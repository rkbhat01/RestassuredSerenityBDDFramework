package com.frameworkdevlopment.cucumber.serenity;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CountrySerenitySteps {
	
	
	@Step("Country get request with Parameter:{0}")
	public Response getCoutry(String Parameter) {
		
		RestAssured.baseURI="http://restcountries.eu/rest/v1";
		
        Response response =SerenityRest.rest().given().when().get(Parameter);
		
		response.then().log().all();
		
		return response;
	}
}
