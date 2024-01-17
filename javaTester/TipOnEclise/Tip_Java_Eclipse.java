package TipOnEclise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Tip_Java_Eclipse {

static	WebDriver driver;

	public void TC_01() {
WebElement Login = driver.findElement(By.xpath("//button[@name='login']"));
WebElement btnClick = driver.findElement(By.cssSelector(""));
Assert.assertTrue(false);
Assert.assertTrue(false);

	}
}
