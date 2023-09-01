package com.jquery;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Framwork_Bai20_Level11_Upload_Files extends BaseTest {
	String anhFileName = "anh.jpg";
	String bongFileName = "Bong.jpg";
	String courseFileName = "course.jpg";
	String[] multipleFileName = { anhFileName, bongFileName, courseFileName };

	@Parameters({ "browser", "url" }) // đang đặt hàm có biến là browser o xml
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Pertime() {
		// Step 01- Load sigle file
		homePage.uploadMultipleFiles(driver, anhFileName);

		// Step-02: Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadByName(anhFileName));

		// Step 03- Click to Start button
		homePage.clickToStartButton();

		// Step 04- Verify single file upload success
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(anhFileName));

		// Step-05: Verify single file upload image success
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(anhFileName));
	}

	@Test
	public void Upload_02_Multiple_File_Pertime() {
		homePage.refreshCurentPage(driver);
		// Step 01- Load sigle file
		homePage.uploadMultipleFiles(driver, multipleFileName);

		// Step-02: Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadByName(anhFileName));
		Assert.assertTrue(homePage.isFileLoadByName(bongFileName));
		Assert.assertTrue(homePage.isFileLoadByName(courseFileName));

		// Step 03- Click to Start button
		homePage.clickToStartButton();

		// Step 04- Verify single file upload success
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(anhFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(bongFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(courseFileName));

		// Step-05: Verify single file upload image success
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(anhFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(bongFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(courseFileName));
	}

	@AfterClass // Custom close browser/ driver
	public void afterClass() {

		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

	private WebDriver driver;
	private HomePageObject homePage;
}
