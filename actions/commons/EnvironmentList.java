package commons;

import org.openqa.selenium.WebDriver;

public class EnvironmentList extends BasePage {
	private WebDriver driver;

	public EnvironmentList(WebDriver driver) {
		this.driver = driver;

	}

	public static String DEV = "https://dev-demo.nopcommerce.com/";
	public static String TESTING = "https://test-demo.nopcommerce.com/";
	public static String STAGING = "https://staging-demo.nopcommerce.com/";

	public static EnvironmentList valueOf(String upperCase) {
		// TODO Auto-generated method stub
		return null;
	}
}
