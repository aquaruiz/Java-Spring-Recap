package com.mysite.mvcconference.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.mvcconference.model.User;

@RestController
public class UserController {

	@GetMapping("/user")
	public User getUser(@RequestParam(value = "firstname", defaultValue = "John") String firstname,
			@RequestParam(value = "lastname", defaultValue = "Doe") String lastname,
			@RequestParam(value = "age", defaultValue = "21") int age) {
		
		User user = new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setAge(age);
		
		return user;
	}
}
