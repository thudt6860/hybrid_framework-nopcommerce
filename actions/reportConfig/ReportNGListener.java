package reportConfig;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import commons.BaseTest;
import commons.GlobalConstants;

public class ReportNGListener implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false"); // set default =false xuất hết dạng html (đọc thêm link tài liệu để hiểu hơn)

		// get driver from Class BaseTest vì driver đc dùng đầu tiên lấy từ BaseTest
		Object testClass = result.getInstance();
		WebDriver webDriver = ((BaseTest) testClass).getDriverInstance();

		// String screenshotPath = captureScreenshot(webDriver, result.getName());
		String screenshotPath = captureScreenshotBase64(webDriver, result.getName());
		Reporter.getCurrentTestResult();

		// Image File
		// Reporter.log("<br><a target=\"_blank\" href=\"file:///" + screenshotPath + "\">" + "<img src=\"file:///" + screenshotPath + "\" " + "height='100'
		// width='150'/> " + "</a></br>");

		// Base 64
		Reporter.log("<br><a  href=\"data:image/png;base64," + screenshotPath + "\">" + "<img src=\"data:image/png;base64," + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");

		Reporter.setCurrentTestResult(null);

	}

	public String captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // thư viện chụp của selenium

			// Đường dẫn của hình-> chụp xong lưu vào đây
			String screenPath = GlobalConstants.REPORTNG_SCREENSHOT + screenshotName + "_" + formater.format(calendar.getTime()) + ".png";
			FileUtils.copyFile(source, new File(screenPath)); // copy file vào trong đường dẫn screenPath
			return screenPath;
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
			return e.getMessage();
		}
	}

	public String captureScreenshotBase64(WebDriver driver, String screenshotName) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
