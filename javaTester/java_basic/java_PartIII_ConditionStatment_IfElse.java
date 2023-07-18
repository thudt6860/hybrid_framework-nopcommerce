package java_basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class java_PartIII_ConditionStatment_IfElse {
 WebDriver driver;
 String projectPath = System.getProperty("user.dir");
 //@Test
 public void TC_01_If() {}
	 
//@Test
	 public void TC_02_If_Else() {
		// Có tới 2 điều kiện: nếu như đúng thì vào if- sai thì vào else 
	
	// Nếu driver start với browser như Chrome/ Firefox/ Edge/ Safari thì dùng hàm click thay doi vao luc 6:26
	// Thông thường (builtin) của Selenium WebElement
	
	// Nếu driver là IE thì dùng hàm click của JavascriptExecutor
	
	//System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
	//driver = new InternetExplorerDriver();
	
	System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
	driver = new FirefoxDriver();
	System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	driver = new ChromeDriver();
	
	System.out.println(driver.toString());
	
	if(driver.toString().contains("internet explorer")) {
		System.out.println("Click by Javascript Executor");
		
	}else {
		System.out.println("click by selenium Webelement");
	}
	
	 }
//@Parameters("browser")
//@Test
public void TC_03_If_Else_If_Else(String browserName) {
	
	// Có nhiều điều kiện
	// Best Practice: Không nên If-else quá nhiều
	
	if (browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
	} else if(browserName.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}else if(browserName.equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
	driver = new EdgeDriver();
	}else {//Safari/Opera...
		throw new RuntimeException("Please input correct the browser name");
	}
	System.out.println(browserName);
	System.out.println(driver.toString());
	driver.quit();
 }

@Test
public void TC_04_If_Else_If_Else() {
	// Page Object
	// Dynamic Page
	
	String pageName = "Login";
	if(pageName.equals("Login")) {
		// LoginPage loginPage = new LoginPage();
		// return loginPage;
	}else if(pageName.equals("Register")) {
		// RegisterPage registerPage = new RegisterPage();
		// return registerPage;
	}else if(pageName.equals("New Customer")) {
		// CustomerPage customerPage = new CustomerPage();
		// return customerPage;
	}else {
		// HomePage homepage = new HomePage();
		// return homePage;
	}
	
	// if- else tương đương biểu thức tam nguyên
	int age =20;
	String access=(age<18)?"You can not access" : "Welcome to our system!";
	
   if(age<18) {
	   access = "You can not access";
   }else {
	   access ="Welcome to our system!";
   }
}
}

 

