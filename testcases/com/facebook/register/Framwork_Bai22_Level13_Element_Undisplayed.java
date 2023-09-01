package com.facebook.register;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Framwork_Bai22_Level13_Element_Undisplayed extends BaseTest {

	private WebDriver driver;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);

	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateANewAccountButton();
		// Nếu 1 cái hàm chỉ mong đợi để verify element displayed thôi thì kết hợp cả Wait + isDisplayed
		// waitForElementVisible
		// isElementDisplayed
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());

		// Verify true- mong đợi Confirm Email Displayed(true)
		loginPage.enterToEmailAddressTextbox("test@gmail.com");
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());

	}

	@Test
	public void TC_02_Verify_Element_UnDisplayed_In_DOM() {
		// Nếu như mình mong đợi 1 cái hàm vừa verify displayed vừa undisplayed thì không kết hợp wait
		// chỉ dùng isElementDisplayed

		// Verify false- mong đợi Confirm Email UnDisplayed (false)
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(3);

		// Cach 1
		// verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());

		// Cách 2:

		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());

	}

	@Test
	public void TC_03_Verify_Element_UnDisplayed_Not_In_DOM() {
		loginPage.clickToIconCloseAtRegisterForm();
		loginPage.sleepInSecond(3);

		// Khi close cái form Register đi thì Confirm Email không còn trong DOM nữa
		// Nên hàm findElement sẽ bị fail vì không tìm thấy element
		// 1- Nó sẽ chờ hết timeout của implicit: 30s
		// 2- Nó sẽ đánh fail testcase tại đúng step này luôn
		// 3- Không chạy các step còn lại nữa

		// Verify False - mong đợi Confirm Email Undisplayed (false)
		// Hàm isDisplayed: bản chất không kiểm tra 1 element không có trong DOM được
		// verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());

		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
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
