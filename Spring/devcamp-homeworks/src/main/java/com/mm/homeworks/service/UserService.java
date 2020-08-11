package com.mm.homeworks.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mm.homeworks.model.dto.UserDto;
import com.mm.homeworks.model.entity.User;
import com.mm.homeworks.repository.UserJdbcRepository;

@Service
public class UserService {
	private final UserJdbcRepository userRepository;
    private final ModelMapper modelMapper;
	
	public UserService(UserJdbcRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	public UserDto[] findAllUsers() {
		List<User> users = userRepository.findAll();
		UserDto[] result = this.modelMapper.map(users, UserDto[].class);
		return result;
	}
}
