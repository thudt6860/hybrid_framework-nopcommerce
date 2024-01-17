package com.liveguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.liveGuru.HomePageObject;
import pageObject.liveGuru.LoginPagePbject;
import pageObject.liveGuru.MyDashboardPageObject;
import pageObject.liveGuru.PageGeneratorManager;
import pageObject.liveGuru.RegisterPageObject;

public class Framwork_Bai11_Page_Generator_Manager_III extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private HomePageObject homePage;
	private LoginPagePbject loginPage;
	private MyDashboardPageObject myDashboard;
	private RegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		firstName = "Thu";
		lastName = "Duong";
		emailAddress = "thu" + generateFakeNumber() + "@gmail.com";
		password = "1234567";

	}

	@Test
	public void Register() {
		homePage.clickToAccountLink();
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailAddressTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPassword(password);
		myDashboard = registerPage.clickToRegisterButton();

		Assert.assertTrue(myDashboard.isMyAccountLinkDisplayed());

	}

	// @Test
	public void Login_02_Invalid_Email() {

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
