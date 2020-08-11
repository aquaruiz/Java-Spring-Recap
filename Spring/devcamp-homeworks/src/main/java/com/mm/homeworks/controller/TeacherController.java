package com.mm.homeworks.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mm.homeworks.model.dto.TeacherCreateDto;
import com.mm.homeworks.model.dto.TeacherDto;
import com.mm.homeworks.service.TeacherService;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {
	private final TeacherService teacherService;
	private final ModelMapper mapper;

	public TeacherController(TeacherService teacherService, ModelMapper mapper) {
		this.teacherService = teacherService;
		this.mapper = mapper;
	}

	@GetMapping("/all")
	public TeacherDto[] getAllTeachers() {
		return teacherService.findAll();
	}

	@PostMapping("/create")
	@ResponseStatus(value = HttpStatus.CREATED)
	public TeacherDto createNewTeacher(@RequestBody TeacherCreateDto request) {
		return teacherService.createNewTeacher(request);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public int deleteTeacher(@PathVariable Long id) {
		return teacherService.deleteTeacher(id);
	}
}
