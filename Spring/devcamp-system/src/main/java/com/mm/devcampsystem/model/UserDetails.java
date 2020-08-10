package com.mm.devcampsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String details;

	public Long getId() {
		return id;
	}
	public String getDetails() {
		return details;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}
