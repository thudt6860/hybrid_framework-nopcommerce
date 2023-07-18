package java_basic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic03_IfElse_Excercise {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
//	@Test
	public void TC_01() {
		
		int number = scanner.nextInt();
		if(number%2==0) {
			System.out.println("số " +number + " là số chẵn");
		}else {
			System.out.println("số " +number + " là số lẻ");
		}
	}
	
	//@Test
	public void baitap02() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		if (numberA > numberB) {
			System.out.println("Số"+numberA + " > số "+ numberB);
		} else if(numberA < numberB){
            System.out.println("Số"+numberA + " < số "+ numberB);
		}else {
			 System.out.println("Số"+numberA + " = số "+ numberB);
		}
		
	}
	//@Test
	public void baitap03() {
		String firstStudent = scanner.nextLine();
		String secondStudent = scanner.nextLine();
		// Cach1
		// Reference: String
		// Kiểm tra cái value của biến
		// Kiểm tra vị trí của biến trong vùng nhớ
		
		if(firstStudent.equals(secondStudent)) {
			System.out.println("2 người cùng tên");
		}else {
			System.out.println("2 người khác tên");
		}
		
		if(firstStudent == secondStudent) {
			System.out.println("2 người cùng tên");
		}else {
			System.out.println("2 người khác tên");
		}
	}
	
	//@Test
	public void baitap04() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();
		
		if (numberA> numberB && numberA> numberC) {
			System.out.println(numberA + " là số lớn nhất");
		} else if(numberB > numberC){
			System.out.println(numberB + " là số lớn nhất");
		}else {
			System.out.println(numberC + " là số lớn nhất");
		}
	}
	
	//@Test
	public void baitap05() {
		int numberA = scanner.nextInt();
		
		if (numberA>10 && numberA<100) {
			System.out.println(numberA + " Nằm trong khoảng (10- 100)");
		} else {
           System.out.println(numberA + " ngoài khoảng (10-100)");
		}
	}
	
	//@Test
	public void baitap06() {
		float numberA = scanner.nextFloat();
		if (numberA>=0 && numberA<5) {
			System.out.println("Điểm D");
		} else if(numberA>=5 && numberA<7.5) {
           System.out.println("Điểm C");
		}else if(numberA>=7.5 && numberA<8.5){
			System.out.println("Điểm B");
		}else if(numberA>=8.5 && numberA<=10) {
			System.out.println("Điểm A");
		}else {
			System.out.println("Vui long nhap lại điểm: ");
		}
	}
	
	@Test
	public void baitap07() {
		int month = scanner.nextInt();
		// tháng có 31 ngày là 1 3 5 7 8 10 12
		if (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12 ) {
			System.out.println("Tháng này có 31 ngày");
		} else if(month ==2) {
           System.out.println("Tháng này có 28 ngày");
		}else if(month == 4|| month == 6 || month == 9 || month== 11) {
			System.out.println("Tháng này có 30 ngày");
		}
	}
}
