package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	// HomePageUI homePageUI = new HomePageUI(); // nếu HomePageUI.java tương ứng có dùng static cho locator thì k cần khởi tạo ở đây
	private WebDriver driver; // biến global

	public HomePageObject(WebDriver driver) { // hàm khởi tạo không có kiểu dữ liệu trả về

		this.driver = driver; // dùng this lấy chính biến global,
								// biến trong hàm bằng biến global; thực tế là biến global của Page_object là local cho HomePageObject
		System.out.println("Driver at Home Page =  " + driver.toString());
	}

	public RegisterPageObject clickToRegisterLink() {
		// System.out.println(homePageUI.EMAIL_TEXTBOX) // dùng cho khởi tạo HomePageUI
		// System.out.println(HomePageUI.REGISTER_LINK); // nếu dùng static thì chỉ việc gọi HomePageUI class luôn
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		// Cách 2:
		// return new RegisterPageObject(driver);
		// Cách 3:
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		// Cách 2: PageGeneratorManager
		// return new LoginPageObject(driver);
		return PageGeneratorManager.getLoginPage(driver);

	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);

	}

	public CustomerInfoPageObject clickToLinkMyAccountLink() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);

	}

}
