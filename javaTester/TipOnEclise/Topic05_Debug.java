package TipOnEclise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic05_Debug {
WebDriver driver;

@Test
public void TC_01() {
	System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
	driver = new ChromeDriver();

	driver.get("https://www.facebook.com/");

	String headerText = driver.findElement(By.xpath("//img[@alt='Facebook']/parent::div/following-sibling::div")).getText();

	Assert.assertEquals(headerText, "Recent logins");

	boolean loginStatus = driver.findElement(By.name("login")).isDisplayed();
	Assert.assertTrue(loginStatus);


}
}
