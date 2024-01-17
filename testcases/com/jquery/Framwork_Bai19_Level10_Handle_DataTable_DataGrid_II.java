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

public class Framwork_Bai19_Level10_Handle_DataTable_DataGrid_II extends BaseTest {
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

	// @Test
	public void Table_03_Enter_To_Header() {
		// Đọc dữ liệu của file country.txt ra
		// Lưu vào 1 List<String> = Expected Value = expectedAllCountryValues

		// Actual Value
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(expectedAllCountryValues, actualAllCountryValues);
	}

	@Test
	public void Table_04_Action_At_Any_Row() {
		// Value để nhập liệu- tham số 1
		// Row number: tại row nào
		// Example: Nhập vào textbox tại dòng số 3/5/2
		// Column name: Company/Contact Person/ Order Placed (Note: chỉ lấy là textbox)
		homePage.clickToLoadButton();
		homePage.sleepInSecond(4);

		// homePage.enterToTextboxByColumnNameAtRowNumber("Company", "1", "Michael 97"); // nhập vào cột Company dòng 1, giá trị là gì?
		// homePage.sleepInSecond(2);
		// homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "1", "Admin");
		// homePage.sleepInSecond(2);
		// homePage.enterToTextboxByColumnNameAtRowNumber("Company", "2", "BO");
		// homePage.sleepInSecond(2);
		// homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "3", "Admin1");
		// homePage.sleepInSecond(2);
		// homePage.selectDropdownByColumnNameAtRowNumber("Country", "5", "Japan");
		// homePage.sleepInSecond(2);
		// homePage.selectDropdownByColumnNameAtRowNumber("Country", "1", "Malaysia");
		// homePage.sleepInSecond(1);
		//
		// homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "2");
		// homePage.sleepInSecond(2);
		// homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");
		// homePage.sleepInSecond(2);
		// homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "6");
		// homePage.sleepInSecond(2);
		//
		// homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");
		// homePage.sleepInSecond(2);
		// homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?", "4");
		// homePage.sleepInSecond(2);
		// homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?", "5");
		// homePage.sleepInSecond(2);
		// homePage.inputNumberByColumnNameAtRowNumber("Order Placed", "1", "123");
		// homePage.inputNumberByColumnNameAtRowNumber("Order Placed", "2", "123456");

		// Thao tác trên các icon
		// Chú ý: khi remove icon thì bản ghi bị xóa index cũng thay đổi, tương tự cho insert bản ghi
		homePage.clickToIconByRowNumber("1", "Remove Current Row"); // dong 1 thuc hien xoa
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("3", "Move Up");
		homePage.sleepInSecond(2);

		homePage.clickToIconByRowNumber("8", "Remove Current Row");
		homePage.clickToIconByRowNumber("7", "Remove Current Row");
		homePage.clickToIconByRowNumber("6", "Remove Current Row");
		homePage.clickToIconByRowNumber("5", "Remove Current Row");
		homePage.clickToIconByRowNumber("4", "Remove Current Row");
		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
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
