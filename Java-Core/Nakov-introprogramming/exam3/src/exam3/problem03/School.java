package exam3.problem03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class School {
	private String name;
	private List<Teacher> teachers;
	private List<Group> groups;
	private List<Student> students;

	public School(String name) {
		this.name = name;
		this.teachers = new ArrayList<>();
		this.groups = new ArrayList<>();
		this.students = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Teacher> getTeachers() {
		return Collections.unmodifiableList(teachers);
	}

	public void addTeacher(Teacher teacher) {
		this.teachers.add(teacher);
	}

	public List<Group> getGroups() {
		return Collections.unmodifiableList(groups);
	}

	public void addGroup(Group group) {
		this.groups.add(group);
	}

	public List<Student> getStudents() {
		return Collections.unmodifiableList(students);
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("School: %s", name))
			.append(System.lineSeparator());
		
		stringBuilder.append("Teachers:")
			.append(System.lineSeparator());
		
		if (this.teachers.size() == 0) {
			stringBuilder.append("\tNo teachers yet.")
				.append(System.lineSeparator());
		} else {
			for (Teacher teacher : teachers) {
				stringBuilder.append(String.format("\t%s %s", teacher.getFirstName(), teacher.getLastName()))
					.append(System.lineSeparator());
			}
		}
		
		stringBuilder.append("Total Groups:")
			.append(System.lineSeparator());
		
		if (this.groups.size() == 0) {
			stringBuilder.append("\tNo groups yet.")
				.append(System.lineSeparator());
		} else {
			for (Group group : groups) {
				stringBuilder.append(String.format("\t%s", group.getName()))
					.append(System.lineSeparator());
			}
		}
		
		stringBuilder.append("All Students:")
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
