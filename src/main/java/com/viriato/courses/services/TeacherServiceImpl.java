package com.viriato.courses.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viriato.courses.mappers.TeacherMapper;
import com.viriato.courses.model.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

	private TeacherMapper mapper;

	public TeacherServiceImpl(TeacherMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return mapper.getAllTeachers();
	}

}
