package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;

	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		// Cach2: PageGeneratorManager
		// return new HomePageObject(driver);
		// Cách 3:
		return PageGeneratorManager.getHomePage(driver);

	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementClickable(driver, LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, invalidEmail);

	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver, LoginPageUI.UNSUCCESSFULL_ERROR_MESAGE);
		return getElementText(driver, LoginPageUI.UNSUCCESSFULL_ERROR_MESAGE);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

	}

}
