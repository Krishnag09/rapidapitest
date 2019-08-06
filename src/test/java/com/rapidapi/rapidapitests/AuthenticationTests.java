package com.rapidapi.rapidapitests;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class AuthenticationTests {
	
	static String baseurl = "https://currencyconverter.p.rapidapi.com";

	@Test	

	public void authenticationHappyPath() {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("x-rapidapi-host","currencyconverter.p.rapidapi.com","x-rapidapi-key","811f6ec606mshaa3041dd69b0fe8p15b0cbjsndb68ac1c5961")
				.queryParam("from_amount", "1")
				.queryParam("from", "USD" )
				.queryParam("to","SEK")
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
				.queryParam("from_amount", "1")
				.queryParam("from", "USD" )
				.queryParam("to","SEK")
				.when()
				.get(baseurl);
		
		String toamount = response.jsonPath().getString("to_amount");
		String resfromamount = response.jsonPath().getString("toamount");
		String resfrom = response.jsonPath().getString("from");
		assertEquals(resfromamount,"1");
		assertEquals(resfrom,"USD");
		assertEquals(resfrom,"SEK");
		assertNotNull(toamount);

		
	}
	
	//Verifying 404 error when request made with invalid key
	
	@Test

	public void authenticationInvalidKey() {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("x-rapidapi-host","currencyconverter.p.rapidapi.com","x-rapidapi-key","811f6ec606mshaa3041dd69b0fe8p15b0cbjsndb68ac1c59")
				.queryParam("from_amount", "1")
				.queryParam("from", "USD" )
				.queryParam("to","SEK")
				.when()
				.get(baseurl);
		int statuscode = response.getStatusCode();
		assertEquals(statuscode,401);
		
		
	}
	
	//Verifying 404 error when request made with invalid host

	
	@Test

	public void authenticationInvalidHost() {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("x-rapidapi-host","currencyconverter.p.rapidapi.coxxx","x-rapidapi-key","811f6ec606mshaa3041dd69b0fe8p15b0cbjsndb68ac1c59")
				.queryParam("from_amount", "1")
				.queryParam("from", "USD" )
				.queryParam("to","SEK")
				.when()
				.get(baseurl);
		int statuscode = response.getStatusCode();
		assertEquals(statuscode,401);
		
		
	}
	
	
	
		
	}
	
	

