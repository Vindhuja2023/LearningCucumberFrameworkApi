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
import pojoClasses.CreateProductsPojo;

public class ProductStepDefinition extends BaseTest {
	CreateProductsPojo product = new CreateProductsPojo();

	

	@And("the request body is created for product")
	public void the_request_body_is_created_for_product(DataTable dataTable) {
		Map<String, String> requestBodyFields = dataTable.asMaps().get(0);
		product.setName(requestBodyFields.get("name"));
		product.setType(requestBodyFields.get("type"));
		product.setUpc(requestBodyFields.get("upc"));
		product.setDescription(requestBodyFields.get("description"));
		product.setManufacturer(requestBodyFields.get("manufacturer"));
		product.setModel(requestBodyFields.get("model"));

	}

	@When("the endpoint {string} invoked using post method for product")
	public void the_endpoint_invoked_using_post_method_for_product(String endPoint) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String reqBody = objectMapper.writeValueAsString(product);
		response = given().body(reqBody).contentType(ContentType.JSON).when().log().all().post(endPoint);

	}

	@And("validate product id field in response body")
	public void validate_product_id_field_in_response_body() {

		Assert.assertNotNull(response.body().jsonPath().getInt("id"));

	}

	@SuppressWarnings("unchecked")
	@When("the endpoint {string} invoked using patch method and productId{int}")
	public void the_endpoint_invoked_using_patch_method_and_productId(String endPoint, Integer productId) {
		JSONObject reqPara = new JSONObject();
		reqPara.put("name", "Mac Notebook");
		response = given().body(reqPara.toString()).contentType(ContentType.JSON).when().log().all()
				.patch(endPoint + productId);
	}

	@Then("validate updated data reflect in response of product")
	public void validate_updated_data_reflect_in_response_of_product() {
		Assert.assertEquals(response.body().jsonPath().getString("name"), "Mac Notebook");
	}



	

}
