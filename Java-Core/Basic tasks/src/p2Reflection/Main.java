package p2Reflection;

public class Main {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Person person = new Person(52, "Tom");
		Woman woman = new Woman();
		
		Utility.copyFields(person, woman, true);
		System.out.println(woman.getAge());
		System.out.println(woman.getName());
	}

}
