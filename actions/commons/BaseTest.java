package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driverBaseTest;
	private String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();
		} else if (browserName.equals("h_chrome")) {
			// System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			// Browser Option: Selenium 3.xx
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();

		} else if (browserName.equals("h_firefox")) {
			// System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");

			driverBaseTest = new FirefoxDriver(options);

		} else if (browserName.equals("edge")) {
			// System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();
		} else if (browserName.equals("ie")) {
			// System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.iedriver().arch32().setup(); // IE luôn dùng bản 32bit
			driverBaseTest = new InternetExplorerDriver();
		} else if (browserName.equals("opera")) {

			driverBaseTest = WebDriverManager.operadriver().create();
			// driverBaseTest = new OperaDriver();

		} else if (browserName.equals("coccoc")) {
			// Coc coc browser trừ đi 7 version của chrome
			// System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver113.exe");
			WebDriverManager.chromedriver().driverVersion("113.0.5672.63").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driverBaseTest = new ChromeDriver(options);
		} else if (browserName.equals("brave")) {
			// Brave browser version nào dùng chromedriver version đó
			// System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe"); => k cần nữa thay bằng câu WebDriverManager rồi
			WebDriverManager.chromedriver().driverVersion("115.0.5790.111").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driverBaseTest = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name is invalid");
		}
		driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driverBaseTest.get("https://demo.nopcommerce.com/");
		driverBaseTest.get("http://live.techpanda.org/index.php/");
		return driverBaseTest;
	}
}
