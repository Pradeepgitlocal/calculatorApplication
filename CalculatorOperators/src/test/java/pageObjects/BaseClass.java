package pageObjects;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	public static WebDriver driver;
	public CalculatorPage cp;
	public static Logger logger;
	public Properties config;

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
