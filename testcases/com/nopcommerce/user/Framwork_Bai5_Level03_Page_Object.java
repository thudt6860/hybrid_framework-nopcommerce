package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Framwork_Bai5_Level03_Page_Object {
	// Khai báo
	private WebDriver driver;
	private String firstName, lastName, emailAddress, passWord;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String projectPath = System.getProperty("user.dir");

	@BeforeClass // Multiple browser
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Driver at Class test=  " + driver.toString());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);

		driver.get("https://demo.nopcommerce.com/");

		firstName = "Thu";
		lastName = "Duong";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		passWord = "123456";

	}

	@Test
	public void TC_01_Register_Empty_Data() {
		// waitForElementClickable(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		System.out.println("Home Page- step 01: Click to Register link");
		homePage.clickToRegisterLink();

		// waitForElementClickable(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");
		System.out.println("Register Page - step02: Click to Register button");
		registerPage.clickToRegisterButton();

		// Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
		System.out.println("Register Page - Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		// waitForElementClickable(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		System.out.println("Home Page- step 01: Click to Register link");
		homePage.clickToRegisterLink();

		// Nhập data vào các field bắt buộc
		// senkeyToElement(driver, "//input[@id='FirstName']", "Thu");
		// senkeyToElement(driver, "//input[@id='LastName']", "Duong");
		// senkeyToElement(driver, "//input[@id='Email']", "123@456#");
		// senkeyToElement(driver, "//input[@id='Password']", "123456789@");
		// senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456789@");

		System.out.println("Register Page - Step02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox("123@123");
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmPasswordTextbox(passWord);

		System.out.println("Register Page - step03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - step 04: Verify error message displayed ");
		Assert.assertEquals(registerPage.getWrongMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		// waitForElementClickable(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		System.out.println("Home Page - step 01:  Click to Register link");
		homePage.clickToRegisterLink();

		// Nhập data vào các field bắt buộc
		// senkeyToElement(driver, "//input[@id='FirstName']", "Thu");
		// senkeyToElement(driver, "//input[@id='LastName']", "Duong");
		// senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		// senkeyToElement(driver, "//input[@id='Password']", "123456789@");
		// senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456789@");

		System.out.println("Register Page- step02: Input to required fields ");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmPasswordTextbox(passWord);

		// waitForElementClickable(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");
		System.out.println("Register Page- step03: Click button");
		registerPage.clickToRegisterButton();

		// Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
		System.out.println("Register Page- step04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		// waitForElementClickable(driver, "//a[@class='ico-logout']");
		// clickToElement(driver, "//a[@class='ico-logout']");
		// System.out.println("Register Page- step05: Click logout link");
		// registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_04_Register_Existing_EMail() {

		System.out.println("Home Page - step 01:  Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Register Page- step02: Input to required fields ");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmPasswordTextbox(passWord);

		System.out.println("Register Page- step03: Click button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page- step04: Verify ESITING EMAIL error message displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");

	}

	@Test
	public void TC_05_Password_Less_Than_6Chars() {

		System.out.println("Home Page- step01: Click link Register");
		homePage.clickToRegisterLink();

		// Nhập data vào các field bắt buộc

		System.out.println("Register Page- step02: Input to required fields ");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("1234");
		registerPage.inputToConfirmPasswordTextbox("1234");

		System.out.println("Register Page- step03: Click button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page- step04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		System.out.println("Home Page- step01: Click link Register");
		homePage.clickToRegisterLink();

		// Nhập data vào các field bắt buộc

		System.out.println("Register Page- step02: Input to required fields ");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmPasswordTextbox(emailAddress);

		System.out.println("Register Page- step03: Click button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page- step04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");

	}

	@AfterClass // Custom close browser/ driver
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

}
