package com.mm.devcampsystem.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
	private Role role;
	
	public Role() {
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
}
