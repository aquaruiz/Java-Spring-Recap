package com.mm.homeworks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.homeworks.model.entity.Student;
import com.mm.homeworks.repository.StudentRepository;
import com.mm.homeworks.repository.TeacherRepository;
import com.mm.homeworks.repository.UserRepository;

@RestController
public class UserController {
	private UserRepository userRepository;
	private TeacherRepository teacherRepository;
	private StudentRepository studentRepository;
	
	public UserController(UserRepository userRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
		this.userRepository = userRepository;
		this.teacherRepository = teacherRepository;
		this.studentRepository = studentRepository;
	}
	
	@GetMapping("/api/user")
	public String listAll() {
		return "get";
	}
	
	@PostMapping("/api/user")
	public Object create() {
		Student student = studentRepository.findById("7379f65a-72ae-430c-bdc3-a3308e09316a").get();
		System.out.println(student.getUser());
//		User user = new User();
//		user.setPassword("fffdddddf");
		
//		Student student = new Student();
//		student.setAge(5);
//		student.setFirstName("az");
//		student.setUser(user);
//		studentRepository.saveAndFlush(student);
		
		
//		Teacher teacher= new Teacher();
//		teacher.setFullname("assss");
//		teacher.setUser(user);
//		teacherRepository.saveAndFlush(teacher);
		return "post " + student.getUser().getPassword();
	}
}
