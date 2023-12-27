package com.vindhuja.testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty","html:target/cucumber","json:target/cucumber-reports/Cucumber.json"},
		features = "src/test/resources/com/features/GetStores.feature",
		glue = {"com.stepDefinition","com.base"},
		tags = " @GetAllStores",
		dryRun = true,
		monochrome = true)


public class GetStoresTestRunner {

}
