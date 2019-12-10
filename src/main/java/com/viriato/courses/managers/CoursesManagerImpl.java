package com.viriato.courses.managers;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viriato.courses.dtos.CourseDTO;
import com.viriato.courses.model.Course;
import com.viriato.courses.services.CoursesService;

@Component
public class CoursesManagerImpl implements CoursesManager {

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private CoursesService coursesService;

	
	@Override
	public void addCourse(CourseDTO courseDTO) {
		Course course = modelMapper.map(courseDTO , Course.class);
		coursesService.addCourse(course);
		courseDTO.setCourseId(course.getCourseId());
	}

	@Override
	public List<CourseDTO> getAllCourses(String orderTitle) {
		List<Course> allCourses = coursesService.getAllCourses(orderTitle);
		Type listType = new TypeToken<List<CourseDTO>>(){}.getType();
		return modelMapper.map(allCourses, listType);
	}

}
