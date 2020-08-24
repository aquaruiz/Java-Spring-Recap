package com.mm.springtests;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {
	private String firstName;
	private String lastName;
	private int age;
	
	@ManyToOne(targetEntity = Lecturer.class)
	private Lecturer lecturer;
	
	public Student() {
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}
}
