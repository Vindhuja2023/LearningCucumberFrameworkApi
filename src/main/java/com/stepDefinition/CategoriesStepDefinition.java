package com.stepDefinition;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.junit.Assert;

import com.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import pojoClasses.CreateCategoriesPojo;

public class CategoriesStepDefinition extends BaseTest{
	
	CreateCategoriesPojo category = new CreateCategoriesPojo();
	
	@Given("the request body is created for category")
	public void the_request_body_is_created_for_category(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> requestBodyFields = dataTable.asMaps().get(0);
		category.setName(requestBodyFields.get("name"));
		category.setId(requestBodyFields.get("id"));
	}

	@When("the endpoint {string} invoked for category using post method")
	public void the_endpoint_invoked_for_category_using_post_method(String endPoint) throws JsonProcessingException {
	
		ObjectMapper objectMapper = new ObjectMapper();
		String reqBody = objectMapper.writeValueAsString(category);
		response = given().body(reqBody).contentType(ContentType.JSON).when().log().all().post(endPoint);

	}

	@Then("validate category id field in response body")
	public void validate_category_id_field_in_response_body() {

		Assert.assertNotNull(response.body().jsonPath().getInt("id"));

	}

}
