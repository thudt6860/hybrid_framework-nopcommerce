package commons;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	// private String projectPath = System.getProperty("user.dir");
	protected final Log log; // protected chỉ thằng nào thừa kế BaseTest mới dùng được biến này

	protected BaseTest() { // hàm constructor
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("h_chrome")) {
			// System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			// Browser Option: Selenium 3.xx
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equals("h_firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");

			driver = new FirefoxDriver(options);

		} else if (browserName.equals("edge")) {
			// System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("ie")) {
			// System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.iedriver().arch32().setup(); // IE luôn dùng bản 32bit
			driver = new InternetExplorerDriver();
		} else if (browserName.equals("opera")) {

			driver = WebDriverManager.operadriver().create();
			// driverBaseTest = new OperaDriver();

		} else if (browserName.equals("coccoc")) {
			// Coc coc browser trừ đi 7 version của chrome
			// System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver113.exe");
			WebDriverManager.chromedriver().driverVersion("113.0.5672.63").setup();
			ChromeOptions options = new ChromeOptions();

			if (GlobalConstants.OS_NAME.startsWith("windows")) {
				options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			} else {
				options.setBinary("....");
			}

			driver = new ChromeDriver(options);
		} else if (browserName.equals("brave")) {
			// Brave browser version nào dùng chromedriver version đó
			// System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe"); => k cần nữa thay bằng câu WebDriverManager rồi
			WebDriverManager.chromedriver().driverVersion("115.0.5790.111").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name is invalid");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		// driverBaseTest.get("https://demo.nopcommerce.com/");
		driver.get(GlobalConstants.FRONTEND_PAGE_URL);
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("h_firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("ie")) {

			WebDriverManager.iedriver().arch32().setup(); // IE luôn dùng bản 32bit
			driver = new InternetExplorerDriver();
		} else if (browserName.equals("opera")) {

			driver = WebDriverManager.operadriver().create();
			// driverBaseTest = new OperaDriver();

		} else if (browserName.equals("coccoc")) {

			WebDriverManager.chromedriver().driverVersion("113.0.5672.63").setup(); // webdriver manager để tự tải driver trình duyệt
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("brave")) {

			WebDriverManager.chromedriver().driverVersion("115.0.5790.111").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name is invalid");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);

		driver.get(appUrl);
		return driver;
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info(" -------------------------- PASSED -------------------------- ");

		} catch (Throwable e) {// nếu dùng exception thì chỉ show dc 1 lỗi, dùng throwable show được all lỗi
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");

		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	// private String getEnvironmentUrl(String serverName) {
	// String envUrl = null;
	// EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
	// if (environment == EnvironmentList.DEV) {
	// envUrl = "https://dev-demo.nopcommerce.com/";
	// } else if (environment == EnvironmentList.TESTING) {
	// envUrl = "https://test-demo.nopcommerce.com/";
	// } else if (environment == EnvironmentList.STAGING)
	// return envUrl;
	//
	// }
}
