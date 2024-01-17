package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Framwork_Bai8_Level04_Multiple_Browser extends BaseTest {
	// Khai báo
	private WebDriver driverTestClass;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@Parameters("browser") // đang đặt hàm có biến là browser
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName) {
		driverTestClass = getBrowserDriver(browserName);

		homePage = new UserHomePageObject(driverTestClass);

		firstName = "Thu";
		lastName = "Duong";
		invalidEmail = "Duong@afc@123.com";
		notFoundEmail = "test" + generateFakeNumber() + "@mail.com";
		existingEmail = "afc" + generateFakeNumber() + "@gmail.com";
		validPassword = "123456";
		incorrectPassword = "9876543";
		System.out.println("Precondition - step 01:  Click to Register link");
		homePage.clickToRegisterLink();

	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.openLoginPage();

		// Từ trang Home- Click Login Link => chuyển qua trang Login
		loginPage = new UserLoginPageObject(driverTestClass);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.openLoginPage();
		// Từ trang Home- Click Login link => Chuyển qua trang Login
		loginPage = new UserLoginPageObject(driverTestClass);
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03__Email_Not_Found() {
		homePage.openLoginPage();
		// Từ trang Home- Click Login link => Chuyển qua trang Login
		loginPage = new UserLoginPageObject(driverTestClass);
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@AfterClass // Custom close browser/ driver
	public void afterClass() {
		driverTestClass.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

}
