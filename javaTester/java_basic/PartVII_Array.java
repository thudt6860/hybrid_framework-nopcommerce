package java_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartVII_Array {
	// public static void main(String[] args) {
	// int student[] = { 12, 7, 5, 61, 15 };
	// // Lấy ra phần tử đầu tiên
	// System.out.println(student[0]);
	// System.out.println(student[1]);
	// }

	public static void main(String[] args) {
		String studentName[] = { "Nam", "Long", "AN" }; // được define cố định bao nhiêu phần tử khi mình viết code (Compile)
		// dùng for each không kết hợp điều kiện=> ít khi dùng for each để kiểm tra điều kiện vì duyệt cả mảng k lấy ra dc index
		for (String std : studentName) {
			if (std.equals("Long")) {
				System.out.println("Click vào Long");
			}
		}

		// trường hợp động
		ArrayList<String> stdName = new ArrayList<String>();
		// Khi chạy code mới add (Runtime)
		for (String std : studentName) {
			stdName.add(std);
		}

		List<String> names = Arrays.asList("Tom", "Jenny", "Donald");
		for (String name : names) {
			System.out.println("Name: " + name);
		}
		String std_Name = Arrays.toString(studentName);
		System.out.println(std_Name);
	}
}
