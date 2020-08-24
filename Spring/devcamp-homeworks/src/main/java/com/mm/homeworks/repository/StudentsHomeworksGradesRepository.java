package com.mm.homeworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mm.homeworks.model.entity.StudentsHomeworksGrades;

@Repository
public interface StudentsHomeworksGradesRepository extends JpaRepository<StudentsHomeworksGrades, Long> {

}
