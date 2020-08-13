package com.mm.homeworks.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "teachers")
public class Teacher {
	@Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(
            name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "user_id", nullable = false, unique = true, updatable = false)
    private String id;
	
	@Enumerated(EnumType.STRING)
	private Title title;
	
	private String fullname;
	
	@OneToMany(mappedBy = "teacher")
	private Set<Subject> subject;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@MapsId
	@JoinColumn(name = "user_id")
	private User user;
	
	public Teacher() {
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullname;
	}
	
	public String getFullname() {
		return fullname;
	}

	public User getUser() {
		return user;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
