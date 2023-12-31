package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class Framwork_Bai11_Page_Generator_Manager_III extends BaseTest {
	// Khai báo
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject myAccountPage;

	@Parameters("browser") // đang đặt hàm có biến là browser
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Thu";
		lastName = "Duong";
		invalidEmail = "Duong@afc@123.com";
		notFoundEmail = "test" + generateFakeNumber() + "@mail.com";
		existingEmail = "afc" + generateFakeNumber() + "@gmail.com";
		validPassword = "123456";
		incorrectPassword = "9876543";
		System.out.println("Precondition - step 01:  Click to Register link");
		registerPage = homePage.clickToRegisterLink();

		System.out.println("Precondition- step02: Input to required fields ");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		System.out.println("Precondition- step03: Click button");
		registerPage.clickToRegisterButton();

		System.out.println("Precondition- step04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		System.out.println("Precondition- step05: Logout");
		// homePage = registerPage.clickToLogoutLink();
		// // Click logout thì business nó sẽ quay về trang Homepage
		// // 3
		// homePage = new HomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		loginPage = homePage.openLoginPage();
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03__Email_Not_Found() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04__Existing_Email_Empty_Password() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05__Existing_Email_Incorrect_Password() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06__Success() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		myAccountPage = homePage.openMyAccountPage(); // khởi tạo myAccountPage mà chưa dùng tới biến nên đang bị warring ở biến
		// myAccountPage sẽ thực hiện các verify tiếp
		// myAccountPage.checkNewLetter();
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
