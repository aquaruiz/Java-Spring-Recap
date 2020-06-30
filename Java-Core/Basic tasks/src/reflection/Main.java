package reflection;

public class Main {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Person person = new Person(52, "Tom");
		Woman woman = new Woman();
		
		Utility.copyFields(person, woman, false);
		System.out.println(woman.age);
		System.out.println(woman.name);
	}

}
