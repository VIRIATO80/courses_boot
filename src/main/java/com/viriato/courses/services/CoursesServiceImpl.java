package com.viriato.courses.services;

import java.util.Comparator;
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
	public List<Course> getAllCourses(String order) {
		List<Course> courses = mapper.getAllCourses();
		if(order != null)
			orderCourses(order, courses);
		return courses;
	}

	private void orderCourses(String order, List<Course> courses) {
		if("ASC".equals(order)) {
			courses.sort(Comparator.comparing(Course::getTitle));
		} else if("DESC".equals(order)) {
			courses.sort(Comparator.comparing(Course::getTitle).reversed());
		}
	}

	@Override
	public void addCourse(Course newCourse) {
		mapper.addCourse(newCourse);
	}

}
