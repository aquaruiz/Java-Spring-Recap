package com.mm.homeworks.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
	
	@Column
	private String fullname;
	@Column
	private String subject;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@MapsId
//	@JoinColumn(name = "id")
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
	
	public String getSubject() {
		return subject;
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

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
