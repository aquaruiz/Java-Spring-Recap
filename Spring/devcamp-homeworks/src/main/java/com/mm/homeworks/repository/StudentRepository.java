package com.mm.homeworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.homeworks.model.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
