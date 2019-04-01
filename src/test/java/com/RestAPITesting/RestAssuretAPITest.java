package com.RestAPITesting;

import org.testng.annotations.*;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuretAPITest {
	
	//Given Rest end point https://batch8-api-site.dev.cc/wp-json/wp/v2/posts/
	//When i send a HTTP GET request to the server
	//Then i should get 200 OK as a status code 
	
	@Test
	public void firstTest() {
		
		given().
			relaxedHTTPSValidation().
		when().
			get("https://batch8-api-site.dev.cc/wp-json/wp/v2/posts")
		.then()
			.statusCode(200);	
	}
	
	
	//Given Rest end point https://batch8-api-site.dev.cc/wp-json/wp/v2/posts/
		//When i send a HTTP GET request to the server
		//Then i should get 200 OK as a status code and id field should be 9 and title field should be - Posting using REST services
	
	@Test
	public void idTest() {
		
		given().
			relaxedHTTPSValidation().
		when().
			get("https://batch8-api-site.dev.cc/wp-json/wp/v2/posts/9")
		.then()
			.statusCode(200)
		.and()
			.body("id", equalTo(9))
			.body("title.rendered", equalTo("Posting using REST services"));
	}
	
}
