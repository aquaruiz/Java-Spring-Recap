package com.mm.devcampsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.devcampsystem.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

}
