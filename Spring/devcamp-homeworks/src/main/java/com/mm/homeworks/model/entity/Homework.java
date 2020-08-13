package com.mm.homeworks.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "homeworks")
public class Homework {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String content;

	@ManyToOne
	private Subject subject;

	@OneToMany(mappedBy = "homework", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<StudentsHomeworksGrades> studentsHomeworksGradesLinkages;
}
