package com.mm.homeworks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.homeworks.model.entity.Teacher;
import com.mm.homeworks.model.entity.UserType;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	List<Teacher> findByUserType(UserType typ);
	
}
