package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage extends BaseClass{

	public WebDriver ldriver;

	public CalculatorPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "display")
	@CacheLookup
	WebElement txtDisplay;

	@FindBy(xpath = "//input[@value='C']")
	@CacheLookup
	WebElement btnClear;

	@FindBy(id = "divide")
	@CacheLookup
	WebElement btnDivision;

	@FindBy(id = "multiply")
	@CacheLookup
	WebElement btnMultiplication;

	@FindBy(id = "subtract")
	@CacheLookup
	WebElement btnSubtraction;

	@FindBy(id = "add")
	@CacheLookup
	WebElement btnAddition;

	@FindBy(xpath = "//input[@value='=']")
	@CacheLookup
	WebElement btnEqual;

	@FindBy(xpath = "//input[@value='.']")
	@CacheLookup
	WebElement btnDot;

	@FindBy(xpath = "//input[@value='%s']")
	@CacheLookup
	WebElement btnNumbers;

	public void buttonEqual() {
		btnEqual.click();
	}

	public void buttonClear() {
		btnClear.click();
	}

	public void buttonAdd() {
		btnAddition.click();
	}

	public String textDisplay() {
		return txtDisplay.getText();
	}

	public void buttonSubtraction() {
		btnSubtraction.click();
	}

	public void buttonMultiplication() {
		btnMultiplication.click();
	}

	public void buttonDivision() {
		btnDivision.click();
	}

	
}