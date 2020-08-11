package com.mm.homeworks.model.entity;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class Teacher extends User {
	
	@NotEmpty
	private String fullname;

	@NotEmpty
	private String subject;

	@ManyToMany(mappedBy = "teachers")
	private Set<Student> students;

	public Teacher() {
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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
