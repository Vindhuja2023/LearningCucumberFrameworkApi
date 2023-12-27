package com.stepDefinition;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import com.base.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

public class CommonStepDefinition extends BaseTest {


	@Given("the api is available")
	public void the_api_is_available() {
		System.out.println("Executing Given step");
		baseURI = "http://localhost:3030/";
	}
	
	@When("the endpoint {string} invoked")
	public void the_endpoint_invoked(String endPoint) {
		given().contentType(ContentType.JSON).when().log().all().get(endPoint).then().log().all().statusCode(200);

	}

	@When("the endpoint {string} invoked with {int}")
	public void the_endpoint_invoked_with(String endPoint, Integer id) {
		given().contentType(ContentType.JSON).when().log().all().get(endPoint+id).then().log().all().statusCode(200);;

	}

	@Then("validate status code of {int} in response body")
	public void validate_status_in_response_body(Integer statusCode) {
		response.then().log().all().statusCode(statusCode);

	}

	@When("the endpoint {string} invoked using get method")
	public void the_endpoint_invoked_using_get_method(String endPoint) {
		response = when().get(endPoint);
	}

	@When("the endpoint {string} invoked using get method with {int}")
	public void the_endpoint_invoked__using_get_method_with(String endPoint, Integer id) {
		response = when().get(endPoint + id);
	}

	@When("the endpoint {string} invoked using delete method{int}")
	public void the_endpoint_invoked_using_delete_method(String endPoint, Integer productId) {
		response = when().delete(endPoint + productId);

	}

}
