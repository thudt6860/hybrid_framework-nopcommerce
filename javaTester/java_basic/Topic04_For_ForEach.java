package java_basic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic04_For_ForEach {
    WebDriver driver;
//	@Test
	public void TC_01_forInnghinso(){
//		for (int i=1; i<=1000;i++) {
//			System.out.println(i);
//		}
	// List<WebElement> links = driver.findElements(By.id("");
	// links.size();
   
	// Array/List/Set/Queue(index)
	// Index chạy từ 0 nên set i =0 nó mới map với length của mảng
		String[] cityName = {"Ha Noi", "Can Tho", "Da Nang", "Ho Chi Minh"};
//		for(int i=0; i< cityName.length; i++) {
//			System.out.println(cityName[i]);
//		}
		
	// Dùng để chạy qua hết tất cả các giá trị
//		for(String city : cityName) {
//			System.out.println(city);
//		}
		
		for(int i=0;i< cityName.length;i++) {
			if(cityName[i].equals("Da Nang")) {
				// Action
				System.out.println("Do action");
				break;
			}
		}
	}
	
	@Test
	public void TC_02_ForEach() {
		// Array
		
		String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho", "Khanh Hoa", "Hai Phong"};
		// Java Collection
		// Class: ArrayList/ LinkedList/ Vector...
		//Interface: List/Set/Queue
		List<String> cityAddress = new ArrayList<String>();
		System.out.println(cityAddress.size());
		
		// Compile (coding)
		cityAddress.add("Bac Giang");
		cityAddress.add("Ha Giang");
		cityAddress.add("Sa Pa");
		
		System.out.println(cityAddress.size());
		
		// Runtime (Running)
		for(String city : cityName) {
			cityAddress.add(city);
		}
		System.out.println(cityAddress.size());
		
		for(String cityAdd : cityAddress) {
			System.out.println(cityAdd);
		}
		
		// Java Generic
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		// Xử lý dữ liệu/ get text/ value/ css/ attribute
		
		for(WebElement link : links) {
			// Chuyển page
			// Refresh DOM/ HTML
			// ko còn tồn tại
			// fail -> stableElementException
		}
		
		// Sort
		
	}
	
}
