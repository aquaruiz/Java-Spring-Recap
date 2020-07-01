package exam3.problem03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
	private String name;
	private List<Student> students;
	
	public Group(String name) {
		this.name = name;
		this.students = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return Collections.unmodifiableList(students);
	}

	public void addStudent(Student student) {
		if (this.students.contains(student)) {
			return;
		}
		
		this.students.add(student);
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(name)
			.append(System.lineSeparator())
			.append("Students: ")
			.append(System.lineSeparator());
		
		if (this.students.size() == 0) {
			stringBuilder.append("\tNo students yet.")
				.append(System.lineSeparator());
		} else {
			for (Student student : students) {
				stringBuilder.append("\t" + student.toString())
					.append(System.lineSeparator());
			}
		}
		
		return stringBuilder.toString();
	}
}
