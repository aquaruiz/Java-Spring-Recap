package com.mm.devcampsystem.model.entity;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity{
	private String name;
	
//    @PrimaryKeyJoinColumn //onetoone unidirectional
//	@OneToOne(cascade = CascadeType.ALL, optional = false)
//	private UserDetails userDetails;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
