package com.mm.devcampsystem.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String fullname;
	@Column
	private String subject;
	
//	@ManyToMany(mappedBy = "teachers")
//	private Set<Student> students;
	
	public Teacher() {
	}
	
	public String getFullname() {
		return fullname;
	}
	
	public String getSubject() {
		return subject;
	}
	
//	public Set<Student> getStudents() {
//		return Collections.unmodifiableSet(students);
//	}
	
//	public void addStudent(Student student) {
//		if (student == null) {
//			return;
//		}
//		
//		students.add(student);
//	}
}
