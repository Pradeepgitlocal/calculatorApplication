package stepDefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.BaseClass;
import pageObjects.CalculatorPage;

public class Steps extends BaseClass {
	@Before

	public void setup() throws IOException {

		logger = Logger.getLogger("devpinoyLogger");
		PropertyConfigurator.configure("Properties//log4j.properties");
		logger.info("***** Loading log4j.properties file ******");
		setupApplication();
	}

	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		cp = new CalculatorPage(driver);
	}

	@When("User opens calculator application URL")
	public void user_opens_calculator_application_url() {
		driver.get(config.getProperty("PROD_CALCULATOR_APPLICATION_URL"));
		logger.info("***** Launching URL******" + config.getProperty("PROD_CALCULATOR_APPLICATION_URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		logger.info("***** CALCULATOR APPLICATION URL has opened ******");
	}

	double input1;
	String firstValue;

	@When("User click on first button and getValue")
	public double user_click_on_first_button_and_get_value() {
		firstValue = randomString();
		String firstString = firstValue.toString().replace(".0", "");
		driver.findElement(By.xpath("//input[@value='" + firstString + "']")).click();
		input1 = Double.parseDouble(cp.textDisplay());
		waitForAllMethods();
		logger.info("***** First input value is : " + input1 + "  ******");
		return input1;

	}

	double input2;
	String secondValue;

	@When("User click on second button and getValue")
	public double user_click_on_second_button_and_get_value() {
		secondValue = randomString();
		String secondString = secondValue.toString().replace(".0", "");
		driver.findElement(By.xpath("//input[@value='" + secondString + "']")).click();
		input2 = Double.parseDouble(cp.textDisplay());
		waitForAllMethods();
		logger.info("***** Second input value is : " + input2 + "  ******");
		return input2;
	}

	@When("User Click on Add button")
	public void user_click_on_add_button() {
		cp.buttonAdd();
		waitForAllMethods();
		logger.info("***** Method Addition of two Numbers was selected ******");
	}

	@When("User Click on Sub button")
	public void user_click_on_sub_button() {
		cp.buttonSubtraction();
		waitForAllMethods();
		logger.info("***** Method Subtraction of two Numbers was selected ******");
	}

	@When("User Click on Multiply button")
	public void user_click_on_multiply_button() {
		cp.buttonMultiplication();
		waitForAllMethods();
		logger.info("***** Method Multiplication of two Numbers was selected ******");
	}

	@When("User Click on Divide button")
	public void user_click_on_divide_button() {
		cp.buttonDivision();
		waitForAllMethods();
		logger.info("***** Method Division of two Numbers was selected ******");
	}

	@When("User click on Equal button")
	public void user_click_on_equal_button() {
		cp.buttonEqual();
		waitForAllMethods();

	}

	@When("User compare results for Add")
	public void user_compare_results_for_Add() {
		logger.info("***** Results button was selected ******");

		double resultByCoding = getAddition(firstValue, secondValue);
		logger.info("***** Result from Addition Method : " + resultByCoding + "  ******");
		double resultByCalcApp = input1 + input2;
		logger.info("***** Result from Calculator Addition Method : " + resultByCalcApp + "  ******");

		// assertEquals(resultByCoding, resultByCalcApp);
		softAssert = new SoftAssert();
		softAssert.assertEquals(resultByCoding, resultByCalcApp, "Comparing both results");
		softAssert.assertAll();
		logger.info("***** Results are same " + resultByCoding + "  ,  " + resultByCalcApp + " ******");
		waitForAllMethods();
	}

	@When("User compare results for Sub")

	public void user_compare_results_for_Sub() {
		logger.info("***** Results button was selected ******");

		double resultByCoding = getSubtraction(firstValue, secondValue);
		logger.info("***** Result from Subtraction Method : " + resultByCoding + "  ******");
		double resultByCalcApp = input1 + input2;
		logger.info("***** Result from Calculator Subtraction Method : " + resultByCalcApp + "  ******");
		// assertEquals(resultByCoding, resultByCalcApp);
		softAssert.assertEquals(resultByCoding, resultByCalcApp, "Comparing both results");
		softAssert.assertAll();
		logger.info("***** Results are same " + resultByCoding + "  ,  " + resultByCalcApp + " ******");
		waitForAllMethods();
	}

	@When("User compare results for Multiply")
	public void user_compare_results_for_Multiply() {
		logger.info("***** Results button was selected ******");

		double resultByCoding = getMultiplication(firstValue, secondValue);
		logger.info("***** Result from Multiplication Method : " + resultByCoding + "  ******");
		double resultByCalcApp = input1 + input2;
		logger.info("***** Result from Calculator Multiplication Method : " + resultByCalcApp + "  ******");

		// assertEquals(resultByCoding, resultByCalcApp);
		softAssert.assertEquals(resultByCoding, resultByCalcApp, "Comparing both results");
		softAssert.assertAll();
		logger.info("***** Results are same " + resultByCoding + "  ,  " + resultByCalcApp + " ******");
		waitForAllMethods();
	}

	@When("User compare results for Divide")
	public void user_compare_results_for_Divide() {
		logger.info("***** Results button was selected ******");

		double resultByCoding = getDivision(firstValue, secondValue);
		logger.info("***** Result from Division Method : " + resultByCoding + "  ******");
		double resultByCalcApp = input1 + input2;
		logger.info("***** Result from Calculator Division Method : " + resultByCalcApp + "  ******");

		// assertEquals(resultByCoding, resultByCalcApp);
		softAssert.assertEquals(resultByCoding, resultByCalcApp, "Comparing both results");

		logger.info("***** Results are same " + resultByCoding + "  ,  " + resultByCalcApp + " ******");
		waitForAllMethods();
	}

	@Then("Results will be Displayed")
	public void results_will_be_displayed() {
		cp.textDisplay();
		waitForAllMethods();
		logger.info("***** Results will be displayed on the Screen ******");

	}

	@Then("Close the Browser")
	public void close_the_browser() throws InterruptedException {
		waitForAllMethods();
		logger.info("***** CALCULATOR APPLICATION URL has Closed ******");
		driver.quit();
	}

}
