package com.mm.homeworks.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mm.homeworks.model.dto.TeacherCreateDto;
import com.mm.homeworks.model.dto.TeacherDto;
import com.mm.homeworks.model.entity.Teacher;
import com.mm.homeworks.model.entity.UserType;
import com.mm.homeworks.repository.TeacherRepository;

@Service
public class TeacherService {
	private final TeacherRepository teacherRepository;
	private final ModelMapper modelMapper;
	
	public TeacherService(TeacherRepository teacherRepository, ModelMapper modelMapper) {
		this.teacherRepository = teacherRepository;
		this.modelMapper = modelMapper;
	}
	
	public TeacherDto[] findAll() {
		List<Teacher> teachers = teacherRepository.findByUserType(UserType.TEACHER);
		return modelMapper.map(teachers, TeacherDto[].class);
	}

	public TeacherDto createNewTeacher(TeacherCreateDto teacherCreateDto) {
		Teacher newTeacher = modelMapper.map(teacherCreateDto, Teacher.class);
		newTeacher.setUserType(UserType.TEACHER);
		Teacher result = teacherRepository.saveAndFlush(newTeacher);
		return modelMapper.map(result, TeacherDto.class);
	}

}
