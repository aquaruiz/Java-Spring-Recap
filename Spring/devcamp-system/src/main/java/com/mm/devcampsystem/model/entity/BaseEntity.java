package com.mm.devcampsystem.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(generator = "uuid-string")
	@GenericGenerator(name = "uuid-string", 
					strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private String id;

	public BaseEntity() {
	}

	public String getId() {
		return id;
	}
}