package com.stepDefinition;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.junit.Assert;

import com.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import pojoClasses.CreateServicesPojo;

public class ServicesStepDefinition extends BaseTest {

	CreateServicesPojo service = new CreateServicesPojo();

	@And("the request body is created for service")
	public void the_request_body_is_created_for_service(DataTable dataTable) {
		Map<String, String> requestBodyFields = dataTable.asMaps().get(0);
		service.setName(requestBodyFields.get("name"));
	}
	
	@When("the endpoint {string} invoked for service using post method")
	public void the_endpoint_invoked_for_category_using_post_method_(String endPoint) throws JsonProcessingException {
	
		ObjectMapper objectMapper = new ObjectMapper();
		String reqBody = objectMapper.writeValueAsString(service);
		response = given().body(reqBody).contentType(ContentType.JSON).when().log().all().post(endPoint);

	}

	@Then("validate service id field in response body")
	public void validate_service_id_field_in_response_body() {

		Assert.assertNotNull(response.body().jsonPath().getInt("id"));

	}
}
