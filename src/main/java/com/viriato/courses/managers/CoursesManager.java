package com.viriato.courses.managers;

import java.util.List;

import com.viriato.courses.dtos.CourseDTO;

public interface CoursesManager {

	public void addCourse(CourseDTO course);

	public List<CourseDTO> getAllCourses(String orderTitle);

}
