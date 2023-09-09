package java_basic;

public class Topic7_Array {

	private String name;
	private int age;

	// Constructor: hàm khởi tạo
	public Topic7_Array(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}

	public static void main(String[] args) {
		Topic7_Array[] students = new Topic7_Array[3];
		students[0] = new Topic7_Array("Tuan", 24);
		students[1] = new Topic7_Array("Thu", 25);
		students[2] = new Topic7_Array("Thang", 31);

		for (Topic7_Array student : students) {
			student.display();
		}
	}
}
