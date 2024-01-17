package java_basic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic04_SwitchCase_For_ForEach {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);

	@Parameters("browser")
	//@Test
	public void TC_01_Switch_Case(String browserName) {
		driver = getBrowserDriver(browserName);
		System.out.println(browserName);

		driver.quit();
	}

	//@Test
	public void TC_02_showSoNgayCuaThang() {
		int month = scanner.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng này có 31 ngày");
			break;
		case 2:
			 System.out.println("Tháng này có 28 ngày");
			 break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng này có 30 ngày");
			break;
		default:
			System.out.println("Vui long nhap thang trong khoảng từ 1-12");
			break;

		}
		}

	//@Test
	public void TC_03_showSoTiengAnh() {
		// Cannot switch on a value of type float. Only convertible int values, strings or enum variables are permitted
		// Nhược điểm của switch- case: 1- chỉ nhận int/string/enum;
		// 2- Không dùng với các toán tử trong case: = < > != ==
		// Nhược điểm của If-else: khó để đọc code; không check trùng lặp

		// enum variables= constant;

		int number = scanner.nextInt();
		switch (number) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			 System.out.println("Eight");
			 break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			 System.out.println("Ten");
			 break;
		default:
			System.out.println("Vui long nhap thang trong khoảng từ 1-10");
			break;

		}
		}


	@Test
	public void TC_04_PhepToan() {
		int numberA = scanner.nextInt();
		scanner.nextLine();
		int numberB = Integer.parseInt(scanner.nextLine());
		String toantu = scanner.nextLine();
		switch(toantu) {
		case "+":
			System.out.println("A+B ="+ (numberA + numberB));
			break;
		case "-":
			System.out.println("A- B = " + (numberA- numberB));
			break;

		case "*":
			System.out.println("A*B = " + (numberA* numberB));
			break;
		case "/":
			System.out.println("A/B = " + (numberA/numberB));
			break;
		case "%":
			System.out.println("A%B = " + (numberA%numberB));
			break;
		}
	}

	public WebDriver getBrowserDriver(String browserName) {

		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			new RuntimeException("Please input correct the browser name!");
		    break;
		}
		return driver;

	}



}


