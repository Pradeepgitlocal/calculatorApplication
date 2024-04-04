package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public CalculatorPage cp;
	public static Logger logger;
	public static Properties config;
	public SoftAssert softAssert;

	public static void setupApplication() throws FileNotFoundException {
		config = new Properties();
		// System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream("Properties//config.properties");
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("***** Loading config.properties file");
		String Browser = config.getProperty("BROWSER");
		if (Browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("***** Selected Chrome Browser ******");
		} else if (Browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("***** Selected firefox Browser ******");
		} else if (Browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("***** Selected EdgeDriver Browser ******");
		}
	}

	// Created for generating random number for unique numbers
	public static String randomString() {
		return RandomStringUtils.randomNumeric(1);

	}

	public static double getAddition(String firstValue, String secondValue) {
		int firstValue1 = Integer.valueOf(firstValue);
		int secondValue1 = Integer.valueOf(secondValue);
		return firstValue1 + secondValue1;

	}

	public static double getSubtraction(String firstValue, String secondValue) {
		int firstValue1 = Integer.valueOf(firstValue);
		int secondValue1 = Integer.valueOf(secondValue);
		return firstValue1 - secondValue1;

	}

	public static double getMultiplication(String firstValue, String secondValue) {
		int firstValue1 = Integer.valueOf(firstValue);
		int secondValue1 = Integer.valueOf(secondValue);
		return firstValue1 * secondValue1;

	}

	public static double getDivision(String firstValue, String secondValue) {
		int firstValue1 = Integer.valueOf(firstValue);
		int secondValue1 = Integer.valueOf(secondValue);
		return firstValue1 / secondValue1;

	}

	public static void waitForAllMethods() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
