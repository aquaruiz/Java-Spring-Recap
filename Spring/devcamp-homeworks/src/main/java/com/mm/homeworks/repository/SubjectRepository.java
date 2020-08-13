package com.mm.homeworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mm.homeworks.model.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
