package com.viriato.courses.services;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.viriato.courses.mappers.CoursesMapper;
import com.viriato.courses.model.Course;


public class CoursesServiceTest {
	
	
	@Mock
	private CoursesMapper mapper;

	private CoursesService service;
	
	List<Course> courses = new ArrayList<Course>();
	
	
   @BeforeEach
   public void initMocks() {
       MockitoAnnotations.initMocks(this);
       service = new CoursesServiceImpl(mapper);
       Course validCourse = new Course();
       courses.add(validCourse);
   }
	   
	   
	@Test
	public void getAllCourses_should_return_list() throws Exception {
		given(mapper.getAllCourses()).willReturn(courses);
		List<Course> courses = service.getAllCourses();
		assertNotNull(courses);
		assertThat(courses.size(), is(1));
	}
}
