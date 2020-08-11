package com.mm.homeworks.model.entity;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Student extends User {
	@NotEmpty
	@Size(max = 50, min = 2)
	private String firstName;

	@NotEmpty
	@Size(max = 50, min = 2)
	private String lastName;

	@Min(16)
	@Max(40)
    @Column(columnDefinition = "integer default 25")
	private int age;
	
	@ManyToMany(targetEntity = Teacher.class)
	@JoinTable(name = "teachers_students", 
				joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"))
	private Set<Teacher> teachers;
	
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

	public Set<Teacher> getTeachers() {
		return Collections.unmodifiableSet(teachers);
	}
	
	public void addTeacher(Teacher teacher) {
		if (teacher == null) {
			return;
		}
		teachers.add(teacher);
	}
}
