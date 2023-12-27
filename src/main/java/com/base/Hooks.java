package com.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void beforeHook(Scenario scenario) {
		System.out.println("****************** "+scenario.getName() + " ********************");

	}

	@After
	public void afterHook() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$ Testcase Finished $$$$$$$$$$$$$$$$$$$$$");
	}

}
