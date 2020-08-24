package com.mm.homeworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.homeworks.model.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

}
