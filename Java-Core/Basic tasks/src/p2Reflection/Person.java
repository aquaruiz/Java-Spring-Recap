package p2Reflection;

public class Person {
//	public int age = 5;
//	public String name = "Tom";
	private int age = 5;
	private String name = "Tom";
	// add private field
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}
}
