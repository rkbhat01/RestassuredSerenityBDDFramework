package com.frameworkdevlopment.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ReuseableSpecifications {
	
	public static RequestSpecBuilder rspec;
	public static RequestSpecification requestSpecification;
		
	public static RequestSpecification getGenericRequestSpec(){
	
		rspec = new RequestSpecBuilder();
		rspec.setContentType(ContentType.JSON);
		requestSpecification = rspec.build();
		return requestSpecification;
		
	}
	
}
