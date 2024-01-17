package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {

	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateANewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.ADDRESS_EMAIL_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.ADDRESS_EMAIL_TEXTBOX);
	}

	public void enterToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.ADDRESS_EMAIL_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.ADDRESS_EMAIL_TEXTBOX, emailAddress);
	}

	public boolean isConfirmEmailAddressTextboxDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_ADDRESS_EMAIL_TEXTBOX);
	}

	public void clickToIconCloseAtRegisterForm() {
		waitForElementVisible(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);

	}

	public boolean isConfirmEmailAddressTextboxUndisplayed() {
		// Mất 5s cho wait
		waitForElementUndisplayed(driver, LoginPageUI.CONFIRM_ADDRESS_EMAIL_TEXTBOX);
		// 5 s cho check undisplay
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_ADDRESS_EMAIL_TEXTBOX);
	}

}
