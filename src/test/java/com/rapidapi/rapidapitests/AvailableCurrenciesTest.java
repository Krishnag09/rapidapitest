package com.rapidapi.rapidapitests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AvailableCurrenciesTest {
	
	static String baseurl = "https://currencyconverter.p.rapidapi.com/availablecurrencies";

	@Test	

	public void authenticationHappyPath() {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("x-rapidapi-host","currencyconverter.p.rapidapi.com","x-rapidapi-key","811f6ec606mshaa3041dd69b0fe8p15b0cbjsndb68ac1c5961")
				.when()
				.get(baseurl);
		
		int statuscode = response.getStatusCode();
		assertEquals(statuscode,200);
	}
	
	
	//Verifying the response parameters

	@Test	

	public void authenticateResponse() {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("x-rapidapi-host","currencyconverter.p.rapidapi.com","x-rapidapi-key","811f6ec606mshaa3041dd69b0fe8p15b0cbjsndb68ac1c5961")
				.when()
				.get(baseurl);
		
	    assertNotNull(response);
		
	}
	
	//Verifying 404 error when request made with invalid key
	
	@Test

	public void authenticationInvalidKey() {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("x-rapidapi-host","currencyconverter.p.rapidapi.com","x-rapidapi-key","811f6ec606mshaa3041dd69b0fe8p15b0cbjsndb68ac1c59xx")
				.when()
				.get(baseurl);
		int statuscode = response.getStatusCode();
		assertEquals(statuscode,401);
		

}
	
	@Test
	public void authenticationInvalidHost() {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("x-rapidapi-host","currencyconverter.p.rapidapi.coxxx","x-rapidapi-key","811f6ec606mshaa3041dd69b0fe8p15b0cbjsndb68ac1c59")
				.when()
				.get(baseurl);
		int statuscode = response.getStatusCode();
		assertEquals(statuscode,401);
		
		
	}
	}
