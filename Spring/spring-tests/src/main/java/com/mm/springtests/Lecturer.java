package com.mm.springtests;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lecturers")
public class Lecturer extends BaseEntity {
	
	private String fullName;
	private String subject;
	
	@OneToMany(mappedBy = "lecturer")
	private Set<Student> students;
	
	public Lecturer() {
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public Set<Student> getStudents() {
		return Collections.unmodifiableSet(students);
	}
	
	public void addStudent(Student student) {
		if (student == null) {
			return;
		}
		
		students.add(student);
	}
}
