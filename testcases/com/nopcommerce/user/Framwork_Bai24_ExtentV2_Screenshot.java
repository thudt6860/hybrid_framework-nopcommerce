package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
//import reportConfig.ExtentTestManager1;

public class Framwork_Bai24_ExtentV2_Screenshot extends BaseTest {
	// Khai báo
	private WebDriver driver;
	private String firstName, lastName, emailAddress, validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;

	@Parameters("browser") // đang đặt hàm có biến là browser
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Thu";
		lastName = "Duong";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		System.out.println(emailAddress);
		validPassword = "123456";

	}

	@Test
	public void User_01_Register(Method method) {
		// ExtentTestManager1.startTest(method.getName(), "User_01_Register");
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to ' Register' page");
		// registerPage = homePage.clickToRegisterLink();
		//
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to FirstName textbox with value is '" + firstName + "'");
		// registerPage.inputToFirstnameTextbox(firstName);
		//
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to LastName textbox with value is '" + lastName + "'");
		// registerPage.inputToLastnameTextbox(lastName);
		//
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email Address textbox with value is '" + emailAddress + "'");
		// registerPage.inputToEmailTextbox(emailAddress);
		//
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		// registerPage.inputToPasswordTextbox(validPassword);
		//
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is '" + validPassword + "'");
		// registerPage.inputToConfirmPasswordTextbox(validPassword);
		//
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Register - Step 07: Click to 'Register' button");
		// registerPage.clickToRegisterButton();
		//
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Register - Step 08: Verify register success message is displayed");
		// Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");
		//
		// // log.info("Register - Step 09: Click to Logout link");
		// // homePage = registerPage.clickToLogoutLink();
		// ExtentTestManager1.endTest();
	}

	@Test
	public void User_02_Login(Method method) {
		// ExtentTestManager1.startTest(method.getName(), "User_02_Login");
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to 'Login Page'");
		// loginPage = homePage.openLoginPage();
		//
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		// loginPage.inputToEmailTextbox(emailAddress);
		//
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		// loginPage.inputToPasswordTextbox(validPassword);
		//
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Register - Step 04: Click to Login button");
		// homePage = loginPage.clickToLoginButton();
		//
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Register - Step 05: Verify 'My Account' link is displayed");
		// Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		//
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Register - Step 06: Navigate to 'My Account' page");
		// customerInfoPage = homePage.openMyAccountPage();
		//
		// ExtentTestManager1.getTest().log(LogStatus.INFO, "Register - Step 07: Verify Customer Infor page is displayed");
		// Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
		// ExtentTestManager1.endTest();
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
