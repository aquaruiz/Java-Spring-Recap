package com.mm.devcampsystem.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private int age;
	
//	@ManyToMany(targetEntity = Teacher.class)
//	@JoinTable(name = "teachers_students", 
//				joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
//				inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"))
//	private Set<Teacher> teachers;
//	
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

//	public Set<Teacher> getTeachers() {
//		return Collections.unmodifiableSet(teachers);
//	}
}
