package com.mm.homeworks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.homeworks.model.entity.Student;
import com.mm.homeworks.model.entity.UserType;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByUserType(UserType typ);

}
