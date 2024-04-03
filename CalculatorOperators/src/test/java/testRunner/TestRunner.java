package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Features", 
		glue = "stepDefination", 
		dryRun = false,
		monochrome = true, 
		plugin = {
		"pretty", "html:target/cucumber-reports" })
// plugin = // {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner {

}
