package com.qa.quickstart.RestAssuredJUnittests;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;


public class Hotels {

	private Response response;
	private RequestSpecification request;
	private ValidatableResponse json;
	
	
	// CREATING A NEW HOTEL
	@Test
	@Ignore
	public void putTest() {
		JSONObject hotel = new JSONObject();
		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels/";
		
		request = given().contentType(ContentType.JSON);
		
		hotel.put("city", "Edinburgh");
		hotel.put("description", "A wonderful hotel in Edinburgh");
		hotel.put("name", "Balmoral hotel");
		hotel.put("rating", 4);
		
		System.out.println(request.body(hotel.toString()));
		
		response = request.post("http://localhost:8090/example/v1/hotels/");
		System.out.println(response.getStatusCode());
	}
	
	// SHOWING ALL HOTELS
	@Test
	@Ignore
	public void getTest() {
		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels/";
		request = given().contentType(ContentType.JSON);
		
		response = request.get("http://localhost:8090/example/v1/hotels/");
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());		
	}
	
	// SHOWING HOTEL BY ID
	@Test
	@Ignore
	public void getByIdTest() {
		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels/";
		request = given().contentType(ContentType.JSON);
		
		response = request.get("http://localhost:8090/example/v1/hotels/5");
		System.out.println(response.getStatusCode());
		System.out.println(response.print());		
	}	

	// MODIFYING HOTEL DETAILS
	@Test
	@Ignore
	public void postTest() {
		JSONObject updateHotel = new JSONObject();
		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels/";
		request = given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:8090/example/v1/hotels/");
		
		
		updateHotel.put("city", "Los Angeles");
		updateHotel.put("description", "Nice five star hotel");
		updateHotel.put("id", "5");
		updateHotel.put("name", "Las Noches");
		updateHotel.put("rating", "5");
		
		System.out.println(request.body(updateHotel.toString()));
		System.out.println(response.getStatusCode());
		response = request.put("http://localhost:8090/example/v1/hotels/5");
	}
	
	// DELETING HOTEL
	@Test
	@Ignore
	public void deleteTest() {
		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels/";
		request = given().contentType(ContentType.JSON);
		
		response = request.delete("http://localhost:8090/example/v1/hotels/5");
		System.out.println(response.getStatusCode());
	}

}
