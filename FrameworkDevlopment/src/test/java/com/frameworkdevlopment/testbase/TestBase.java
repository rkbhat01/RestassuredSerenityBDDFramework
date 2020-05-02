package com.frameworkdevlopment.testbase;

import org.junit.Before;
import org.junit.BeforeClass;

import io.restassured.RestAssured;
import net.thucydides.core.annotations.WithTag;

public class TestBase  {
	
	@BeforeClass()
	public static void init() {
		//RestAssured.baseURI="http://restcountries.eu/rest/v1";
		//RestAssured.baseURI="http://restapi.demoqa.com/customer";
		//RestAssured.baseURI="http://restapi.demoqa.com";
	}


}
