package java_basic;

import org.testng.annotations.Test;

public class Topic42_Part7_While_Do {
	// @Test
	// Function
	public void main() {
		// Block code
		for (int i = 0; i < 5; i++) { // thực hiện câu lệnh rồi mới tăng i
			System.out.println("for: " + i);
			if (i == 3) {
				break;
			}

		}

		int i = 0;
		while (i < 5) {
			System.out.println("While: " + i);
			i++; // tăng i rồi mới thực hiện câu lệnh
			if (i == 3) {
				break;
			}
		}
	}

	@Test
	public void TC02() {
		int i;
		for (i = 0; i < 5; i++) {
			System.out.println("for: " + i);
		}

		System.out.println("Biến i sau khi done vòng for: " + i);

		// i=5 không thỏa mãn điều kiện của While
		// i
		while (i < 5) {
			System.out.println("While " + i);
			i++;
		}
		// Chạy ít nhất 1 lần rồi mới kiểm tra điều kiện
		// Tốt nhất nên dùng for và while
		do {
			System.out.println("Do-While: " + i);
			i++;
		} while (i < 5);

	}

}
