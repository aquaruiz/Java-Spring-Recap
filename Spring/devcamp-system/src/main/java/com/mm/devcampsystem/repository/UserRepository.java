package com.mm.devcampsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.devcampsystem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
