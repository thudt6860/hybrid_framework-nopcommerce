package com.jquery;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;

public class Framwork_Bai18_Level10_Handle_DataTable_DataGrid_I extends BaseTest {
	// Khai báo
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({ "browser", "url" }) // đang đặt hàm có biến là browser o xml
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));

		homePage.openPagingByPageNumber("17");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("17"));

		homePage.openPagingByPageNumber("8");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("8"));

		homePage.openPagingByPageNumber("22");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("22"));

	}

	// @Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurentPage(driver); // nếu muốn chạy 2 test case cùng lúc nên refresh trang tránh nhầm data
		homePage.enterToHeaderTextboxByLabel("Country", "Albania");
		homePage.enterToHeaderTextboxByLabel("Females", "24128");
		homePage.enterToHeaderTextboxByLabel("Males", "25266");
		homePage.enterToHeaderTextboxByLabel("Total", "49397");
		homePage.sleepInSecond(3);

		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.enterToHeaderTextboxByLabel("Females", "276880");
		homePage.enterToHeaderTextboxByLabel("Males", "276472");
		homePage.enterToHeaderTextboxByLabel("Total", "553353");
		homePage.sleepInSecond(3);
	}

	@Test
	public void Table_03_Enter_To_Header() {
		// Đọc dữ liệu của file country.txt ra
		// Lưu vào 1 List<String> = Expected Value = expectedAllCountryValues

		// Actual Value
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(expectedAllCountryValues, actualAllCountryValues);
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
