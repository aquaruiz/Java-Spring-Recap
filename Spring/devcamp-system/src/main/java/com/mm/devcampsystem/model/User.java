package com.mm.devcampsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;
	private String name;
	
    @PrimaryKeyJoinColumn //onetoone unidirectional
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	private UserDetails userDetails;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
}
