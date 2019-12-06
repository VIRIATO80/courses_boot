package com.viriato.courses.services;

import java.util.List;

import com.viriato.courses.model.Course;

public interface CoursesService {

	public List<Course> getAllCourses(String order);

	public void addCourse(Course validCourse);

}
