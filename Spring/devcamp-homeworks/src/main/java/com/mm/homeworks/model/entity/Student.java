package com.mm.homeworks.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "students")
public class Student {
	@Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(
            name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "user_id", nullable = false, unique = true, updatable = false)
    private String id;
	
	private String firstName;
	private String lastName;
	private int age;
	@Column(columnDefinition = "Decimal(3, 2)")
	private double totalScore;
	
	@OneToMany(mappedBy = "student", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<StudentsHomeworksGrades> studentsHomeworksGradesLinkages;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@MapsId
	@JoinColumn(name = "user_id")
	private User user;

	public Student() {
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
