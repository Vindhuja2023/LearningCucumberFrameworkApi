package com.vindhuja.testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty","html:target/cucumber","json:target/cucumber-reports/Cucumber.json"},
		features = "src/test/resources/com/features/GetProducts.feature",
		glue = {"com.stepDefinition","com.base"},
		tags = " @regression",
		monochrome = true)


public class GetProductTestRunner {

}