package exam3.problem03;

public class Main {

	public static void main(String[] args) {
		School school = new School("Свобода");
		Teacher teacher1 = new Teacher("Димитър", "Георгиев");
		Teacher teacher2 = new Teacher("Христина", "Николова");
		
		school.addTeacher(teacher1);
		school.addTeacher(teacher2);
		
		Group group1 = new Group("английски език");
		school.addGroup(group1);

		Student student1 = new Student("Иван", "Петров");
		school.addStudent(student1);
		Student student2 = new Student("Васил", "Тодоров");
		school.addStudent(student2);
		Student student3 = new Student("Елена", "Михайлова");
		school.addStudent(student3);
		Student student4 = new Student("Радослав", "Георгиев");
		school.addStudent(student4);
		Student student5 = new Student("Милена", "Милена");
		school.addStudent(student5);
		
		group1.addStudent(student1);
		group1.addStudent(student2);
		group1.addStudent(student3);
		group1.addStudent(student4);
		group1.addStudent(student5);
		
		teacher2.addGroup(group1);
		
		Group group2 = new Group("френски език");
		school.addGroup(group2);
		
		Student student6 = new Student("Петър", "Петров");
		school.addStudent(student6);
		Student student7 = new Student("Васил", "Василев");
		school.addStudent(student7);
		
		group2.addStudent(student6);
		group2.addStudent(student7);
		
		teacher1.addGroup(group2);
		
		Group group3 = new Group("информатика");
		school.addGroup(group3);

		Student student8 = new Student("Милка", "Колева");
		school.addStudent(student8);
		Student student9 = new Student("Пенчо", "Тошев");
		school.addStudent(student9);
		Student student10 = new Student("Ива", "Борисова");
		school.addStudent(student10);
		Student student11 = new Student("Милена", "Иванова");
		school.addStudent(student11);
		Student student12 = new Student("Христо", "Тодоров");
		school.addStudent(student12);
		
		group3.addStudent(student8);
		group3.addStudent(student9);
		group3.addStudent(student10);
		group3.addStudent(student11);
		group3.addStudent(student12);
		
		Teacher teacher3 = new Teacher("Димитър", "Георгиев");
		school.addTeacher(teacher3);
		teacher3.addGroup(group3);

		
		System.out.println(school);
		System.out.println("======");
		System.out.println(teacher2);
		System.out.println("======");
		System.out.println(student11);
		System.out.println("======");
		System.out.println(group2);
	}

}
