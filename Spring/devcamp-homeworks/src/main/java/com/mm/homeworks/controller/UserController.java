package com.mm.homeworks.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.homeworks.model.dto.UserDto;
import com.mm.homeworks.service.TeacherService;
import com.mm.homeworks.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    private final TeacherService teacherService;
    private final ModelMapper mapper;
    
	public UserController(UserService userService, TeacherService teacherService, ModelMapper mapper) {
		this.userService = userService;
		this.teacherService = teacherService;
		this.mapper = mapper;
	}
    
    @GetMapping("/all")
    public UserDto[] getAllUsers() {
        return userService.findAllUsers();
    }
}
