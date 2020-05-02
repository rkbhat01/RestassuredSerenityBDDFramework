package com.frameworkdevlopment.junit.countriesinfo;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.frameworkdevlopment.cucumber.serenity.CountrySerenitySteps;
import com.frameworkdevlopment.testbase.TestBase;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;

@RunWith(SerenityRunner.class)
public class CountriesTest extends TestBase{
	
	@Steps
	CountrySerenitySteps steps;

	@WithTag("CountryTest")
	@Title("This test verify response Contains Republic of India")
	@Test 
	public void verifyresponseContent() { 
		Response response = steps.getCoutry("/name/INDIA");
		
		Assert.assertTrue(response.getBody().asString().contains("Republic of India"));

	}
	
	@WithTag("CountryTest")
	@Title("This test Verify Error IsDisplayed For Invalid Entry")
	@Test 
	public void VerifyErrorIsDisplayedForInvalidEntry() {
		Response response = steps.getCoutry("/name/xyz");

		Assert.assertEquals(response.getStatusCode(),404);
		Assert.assertEquals(response.jsonPath().get("message"),"Not Found");
	}
	
	@WithTag("CountryTest")
	@Title("This test will verfiy that Norway capital is Oslo")
	@Test
	public void test03() {
		Response response = steps.getCoutry("/name/norway");
			
		HashMap<String,Object> countryMap= response.then().log().all().extract().path("findAll{it.name=='Norway'}.get(0)");
		Assert.assertTrue(countryMap.get("capital").toString().equals("Oslo"));
	}
}
