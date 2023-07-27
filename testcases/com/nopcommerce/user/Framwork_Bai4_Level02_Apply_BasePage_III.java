package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Framwork_Bai4_Level02_Apply_BasePage_III extends BasePage {
	WebDriver driver;
	String emailAddress;

	// Declare (Khai báo)

	// BasePage: Class
	// basePage: Object
	String projectPath = System.getProperty("user.dir");

	@BeforeClass // Multiple browser
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		// C1 Initial (Khởi tạo) trực tiếp không nên dung
		// basePage = new BasePage(); // khai báo biến cho class nhưng chưa khởi tạo sẽ ra lỗi NullPointerException
		// Cách 2: gọi qua hàm đã tạo common bên BasePage -> nên dùng cách này
		// Che giấu đi việc khởi tạo của 1 đối tượng

		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		// Assert.assertEquals (thư viện của testNG): sẽ học wapper lại trong bài Assert/Verify

		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		// Nhập data vào các field bắt buộc
		senkeyToElement(driver, "//input[@id='FirstName']", "Thu");
		senkeyToElement(driver, "//input[@id='LastName']", "Duong");
		senkeyToElement(driver, "//input[@id='Email']", "123@456#");
		senkeyToElement(driver, "//input[@id='Password']", "123456789@");
		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456789@");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		// Nhập data vào các field bắt buộc
		senkeyToElement(driver, "//input[@id='FirstName']", "Thu");
		senkeyToElement(driver, "//input[@id='LastName']", "Duong");
		senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		senkeyToElement(driver, "//input[@id='Password']", "123456789@");
		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456789@");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
		// waitForElementClickable(driver, "//a[@class='ico-logout']");
		// clickToElement(driver, "//a[@class='ico-logout']");

	}

	@Test
	public void TC_04_Register_Existing_EMail() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		// Nhập data vào các field bắt buộc
		senkeyToElement(driver, "//input[@id='FirstName']", "Thu");
		senkeyToElement(driver, "//input[@id='LastName']", "Duong");
		senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		senkeyToElement(driver, "//input[@id='Password']", "123456789@");
		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456789@");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'message-error')]//li"), "The specified email already exists");

	}

	@Test
	public void TC_05_Password_Less_Than_6Chars() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		// Nhập data vào các field bắt buộc
		senkeyToElement(driver, "//input[@id='FirstName']", "Thu");
		senkeyToElement(driver, "//input[@id='LastName']", "Duong");
		senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		senkeyToElement(driver, "//input[@id='Password']", "1234");
		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "1234");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		// Nhập data vào các field bắt buộc
		senkeyToElement(driver, "//input[@id='FirstName']", "Thu");
		senkeyToElement(driver, "//input[@id='LastName']", "Duong");
		senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		senkeyToElement(driver, "//input[@id='Password']", "12345678");
		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "1234986");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");

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
