package com.utils;

import io.restassured.response.Response;

public class TestContext {
	Response response;

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

}
