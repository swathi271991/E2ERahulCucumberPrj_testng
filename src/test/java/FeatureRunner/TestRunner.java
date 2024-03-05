package FeatureRunner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//html, xml, json, junit, extent

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinations", monochrome = true, 
		tags = "@Offers or @Order", plugin = {
		"pretty", "html:target/cucu.html", "json:target/cucu.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed-scenarios.txt"})

public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
