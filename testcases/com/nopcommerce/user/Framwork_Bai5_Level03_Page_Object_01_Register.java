package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Framwork_Bai5_Level03_Page_Object_01_Register {
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
		// Mở Url lên nó qua trang HomePage
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);

		firstName = "Thu";
		lastName = "Duong";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		passWord = "123456";

	}

	@Test
	public void Register_01_Empty_Data() {

		System.out.println("Register_01- step 01: Click to Register link");
		homePage.clickToRegisterLink();

		// Click Register link -> nhảy qua trang Register
		registerPage = new RegisterPageObject(driver);
		System.out.println("Register_01 - step02: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_01 - Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {

		System.out.println("Register_02- step 01: Click to Register link");
		homePage.clickToRegisterLink();

		// Click Register link -> nhảy qua trang Register
		registerPage = new RegisterPageObject(driver);
		System.out.println("Register_02 - Step02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox("123@123");
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmPasswordTextbox(passWord);

		System.out.println("Register_02 - step03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_02 - step 04: Verify error message displayed ");
		Assert.assertEquals(registerPage.getWrongMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Register_03__Success() {

		System.out.println("Register_03 - step 01:  Click to Register link");
		homePage.clickToRegisterLink();

		// Click Register link -> nhảy qua trang Register
		registerPage = new RegisterPageObject(driver);
		System.out.println("Register_03- step02: Input to required fields ");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmPasswordTextbox(passWord);

		System.out.println("Register_03- step03: Click button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_03- step04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void Register_04__Existing_EMail() {

		System.out.println("Register_04 - step 01:  Click to Register link");
		homePage.clickToRegisterLink();

		// Click Register link -> nhảy qua trang Register
		registerPage = new RegisterPageObject(driver);
		System.out.println("Register_04- step02: Input to required fields ");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmPasswordTextbox(passWord);

		System.out.println("Register_04- step03: Click button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_04- step04: Verify ESITING EMAIL error message displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");

	}

	@Test
	public void Register_05__Password_Less_Than_6Chars() {

		System.out.println("Register_05- step01: Click link Register");
		homePage.clickToRegisterLink();

		// Nhập data vào các field bắt buộc

		// Click Register link -> nhảy qua trang Register
		registerPage = new RegisterPageObject(driver);
		System.out.println("Register_05- step02: Input to required fields ");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("1234");
		registerPage.inputToConfirmPasswordTextbox("1234");

		System.out.println("Register_05- step03: Click button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_05- step04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_06_Register_Invalid_Confirm_Password() {
		System.out.println("Register_06- step01: Click link Register");
		homePage.clickToRegisterLink();

		// Nhập data vào các field bắt buộc

		// Click Register link -> nhảy qua trang Register
		registerPage = new RegisterPageObject(driver);
		System.out.println("Register_06- step02: Input to required fields ");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmPasswordTextbox(emailAddress);

		System.out.println("Register_06- step03: Click button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_06- step04: Verify error message displayed");
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
