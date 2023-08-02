package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	// HomePageUI homePageUI = new HomePageUI(); // nếu HomePageUI.java tương ứng có dùng static cho locator thì k cần khởi tạo ở đây
	private WebDriver driver; // biến global

	public HomePageObject(WebDriver driver) { // hàm khởi tạo không có kiểu dữ liệu trả về

		this.driver = driver; // dùng this lấy chính biến globel,
								// biến trong hàm bằng biến global; thực tế là biến global của Page_object là local cho HomePageObject
		System.out.println("Driver at Home Page =  " + driver.toString());
	}

	public void clickToRegisterLink() {
		// System.out.println(homePageUI.EMAIL_TEXTBOX) // dùng cho khởi tạo HomePageUI
		// System.out.println(HomePageUI.REGISTER_LINK); // nếu dùng static thì chỉ việc gọi HomePageUI class luôn
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);

	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);

	}

}
