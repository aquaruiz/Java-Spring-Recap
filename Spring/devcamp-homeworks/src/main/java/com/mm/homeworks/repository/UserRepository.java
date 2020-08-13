package com.mm.homeworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.homeworks.model.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
