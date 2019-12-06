package com.viriato.courses.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viriato.courses.mappers.CoursesMapper;
import com.viriato.courses.model.Course;

@Service
public class CoursesServiceImpl implements CoursesService {

	
	private CoursesMapper mapper;
	
	public CoursesServiceImpl(CoursesMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<Course> getAllCourses() {
		return mapper.getAllCourses();
	}

	@Override
	public void addCourse(Course newCourse) {
		mapper.addCourse(newCourse);
	}

}
