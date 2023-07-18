package java_basic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class BaiTap_Part7_While_DO_While {
	Scanner scanner = new Scanner(System.in);

	// @Test
	public void TC_01_For() {
		int number = scanner.nextInt();
		for (int i = number; i < 100; i++) {
			// Chia hết cho 2
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}

	}

	// @Test
	public void TC_02_While() {
		int number = scanner.nextInt();
		while (number < 100) {
			if (number % 2 == 0) {
				System.out.println(number);
				number++;
			}
		}
	}

	// @Test
	public void TC_03_Do_While() {
		int number = scanner.nextInt();
		do {
			if (number % 2 == 0) {
				System.out.println(number);
				number++;
			}
		} while (number < 100);
	}

	@Test
	public void TC_04_2SoAB() {
		int numberA = scanner.nextInt();
		// int numberB = scanner.nextInt();

		// In từ a tới b
		while (numberA < 100) {
			if (numberA % 3 == 0 && numberA % 5 == 0) {
				System.out.println(numberA);

			}
			numberA++;
		}
	}
}
