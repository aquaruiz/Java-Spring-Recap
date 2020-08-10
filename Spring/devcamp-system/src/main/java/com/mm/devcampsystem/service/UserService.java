package com.mm.devcampsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.devcampsystem.model.User;
import com.mm.devcampsystem.model.UserDetails;
import com.mm.devcampsystem.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void createUser() {
		User user = new User();
		UserDetails userDetails = new UserDetails();
		user.setUserDetails(userDetails);

		userRepository.save(user);
		System.out.println("user set");
	}
}
