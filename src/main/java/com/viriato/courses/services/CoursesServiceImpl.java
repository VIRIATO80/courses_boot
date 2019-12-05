package com.viriato.courses.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viriato.courses.mappers.CoursesMapper;
import com.viriato.courses.model.Course;

@Service
public class CoursesServiceImpl implements CoursesService {

	@Autowired
	private CoursesMapper mapper;
	
	public CoursesServiceImpl(CoursesMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<Course> getAllCourses() {
		return mapper.getAllCourses();
	}

}
