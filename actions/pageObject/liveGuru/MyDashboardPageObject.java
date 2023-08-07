package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
	private WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, MyDashboardPageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, MyDashboardPageUI.MY_ACCOUNT_LINK);
	}
}
