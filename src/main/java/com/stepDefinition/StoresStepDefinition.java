package com.stepDefinition;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Assert;

import com.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import pojoClasses.CreateStorePojo;

public class StoresStepDefinition extends BaseTest {
	protected CreateStorePojo store = new CreateStorePojo();

	@And("the request body is created for store")
	public void the_request_body_is_created_for_store(DataTable dataTable) {

		Map<String, String> requestBodyFields = dataTable.asMaps().get(0);
		store.setName(requestBodyFields.get("name"));
		store.setType(requestBodyFields.get("type"));
		store.setAddress(requestBodyFields.get("address"));
		store.setCity(requestBodyFields.get("city"));
		store.setState(requestBodyFields.get("state"));
		store.setZip(requestBodyFields.get("zip"));

	}

	@When("the endpoint {string} invoked with post method for store")
	public void the_endpoint_invoked_with_post_method_for_store(String endPoint) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String reqBody = objectMapper.writeValueAsString(store);
		response = given().body(reqBody).contentType(ContentType.JSON).when().log().all().post(endPoint);

	}

	@Then("validate store id field in response body")
	public void validate_store_id_field_in_response_body() {

		Assert.assertNotNull(response.body().jsonPath().getInt("id"));

	}
	
	@SuppressWarnings("unchecked")
	@When("the endpoint {string} invoked using patch method and storeId {int}")
	public void the_endpoint_invoked_using_patch_method_and_storeId(String endPoint, Integer storeId) {
		JSONObject reqPara = new JSONObject();
		reqPara.put("name", "BB");
		response = given().body(reqPara.toString()).contentType(ContentType.JSON).when().log().all()
				.patch(endPoint + storeId);
	}

	@Then("validate updated data reflect in response of store")
	public void validate_updated_data_reflect_in_response_of_store() {
		Assert.assertEquals(response.body().jsonPath().getString("name"), "BB");
	}
	

}
