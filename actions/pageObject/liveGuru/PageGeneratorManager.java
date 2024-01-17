package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static MyDashboardPageObject getMyDasboardPage(WebDriver driver) {
		return new MyDashboardPageObject(driver);
	}

}
