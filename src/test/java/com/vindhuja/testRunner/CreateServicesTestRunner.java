package com.vindhuja.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty","html:target/cucumber.html","json:target/cucumber-reports/Cucumber.json"},
		features = "src/test/resources/com/features/CreateServices.feature",
		glue = {"com.stepDefinition","com.base"},
		tags = " @CreateService",
		dryRun = true,
		monochrome = true)


public class CreateServicesTestRunner {

}
