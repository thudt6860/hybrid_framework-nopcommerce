package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage {
	// HomePageUI homePageUI = new HomePageUI(); // nếu HomePageUI.java tương ứng có dùng static cho locator thì k cần khởi tạo ở đây
	private WebDriver driver; // biến global

	public UserHomePageObject(WebDriver driver) { // hàm khởi tạo không có kiểu dữ liệu trả về

		this.driver = driver; // dùng this lấy chính biến global,
								// biến trong hàm bằng biến global; thực tế là biến global của Page_object là local cho HomePageObject
		System.out.println("Driver at Home Page =  " + driver.toString());
	}

	public UserRegisterPageObject clickToRegisterLink() {
		// System.out.println(homePageUI.EMAIL_TEXTBOX) // dùng cho khởi tạo HomePageUI
		// System.out.println(HomePageUI.REGISTER_LINK); // nếu dùng static thì chỉ việc gọi HomePageUI class luôn
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		// Cách 2:
		// return new RegisterPageObject(driver);
		// Cách 3:
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPageObject openLoginPage() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);

	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);

	}

	public UserCustomerInfoPageObject openMyAccountPage() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserMyAccountPage(driver);

	}

}
