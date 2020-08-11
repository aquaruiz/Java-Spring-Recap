package com.mm.devcampsystem.service;

import org.springframework.stereotype.Service;

import com.mm.devcampsystem.model.entity.User;

@Service
public class UserService {

//	private final UserRepository userRepository;

//	@Autowired
//	public UserService(UserRepository userRepository) {
//		th/is.userRepository = userRepository;
//	}

	public void createUser() {
		User user = new User();

//		userRepository.save(user);
		System.out.println("user set");
	}
}
