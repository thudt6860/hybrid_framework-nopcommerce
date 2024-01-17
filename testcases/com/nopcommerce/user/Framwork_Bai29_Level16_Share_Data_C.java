package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Framwork_Bai29_Common_01_Register_Cookie;
import com.nopcommerce.common.Framwork_Bai29_Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Framwork_Bai29_Level16_Share_Data_C extends BaseTest {

	private WebDriver driver;
	private String emailAddress1, validPassword1;
	private UserHomePageObject homePage;

	private UserLoginPageObject loginPage;

	@Parameters("browser") // đang đặt hàm có biến là browser
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress1 = Framwork_Bai29_Common_01_Register_End_User.emailAddress;
		validPassword1 = Framwork_Bai29_Common_01_Register_End_User.validPassword;

		log.info("Precondition - Step 01: Navigate to 'Login Page'");
		loginPage = homePage.openLoginPage();

		log.info("Precondition - Step 02: Set Cookie and reload page");
		loginPage.setCookies(driver, Framwork_Bai29_Common_01_Register_Cookie.loggedCookies);
		for (Cookie cookie : Framwork_Bai29_Common_01_Register_Cookie.loggedCookies) {
			System.out.println("Cookie at C Class:  " + cookie);
		}
		loginPage.refreshCurentPage(driver);

		log.info("Pre-Condition - Step03: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void Search_01_Empty_Data() {

	}

	@Test
	public void Search_02_Relative_Product_Name() {

	}

	@Test
	public void Search_03_Absolute_Product_Name() {

	}

	@Test
	public void Search_04_Parent_Category() {

	}

	@Test
	public void Search_05_Incorrect_Manufacture() {

	}

	@Test
	public void Search_06_Correct_Manufacture() {

	}

	@AfterClass // Custom close browser/ driver
	public void afterClass() {
		// driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

}
