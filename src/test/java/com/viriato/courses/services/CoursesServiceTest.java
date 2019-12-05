package com.viriato.courses.services;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.viriato.courses.model.LevelEnum;


public class CoursesServiceTest {
	
	
	@Mock
	private CoursesMapper mapper;

	private CoursesService service;
	
	private List<Course> courses = new ArrayList<Course>();
	
	private Course validCourse;
	
   @BeforeEach
   public void initMocks() {
       MockitoAnnotations.initMocks(this);
       service = new CoursesServiceImpl(mapper);
       validCourse = new Course();
       validCourse.setTitle("Curso 1");
       validCourse.setActive(true);
       validCourse.setHours(10);
       validCourse.setCourseId(1);
       validCourse.setLevel(LevelEnum.Avanzado);
       courses.add(validCourse);
   }
	   
	   
	@Test
	public void getAllCourses_should_return_list() throws Exception {
		given(mapper.getAllCourses()).willReturn(courses);
		List<Course> courses = service.getAllCourses();
		assertNotNull(courses);
		assertThat(courses.size(), is(1));
		assertThat(courses.get(0).getTitle()).isEqualTo("Curso 1");
		assertThat(courses.get(0).isActive()).isEqualTo(true);
		assertThat(courses.get(0).getCourseId()).isEqualTo(1);
		assertThat(courses.get(0).getHours()).isEqualTo(10);
		assertThat(courses.get(0).getLevel()).isEqualTo(LevelEnum.Avanzado);
	}
	
	@Test
	public void addCourse_test() throws Exception {
		service.addCourse(validCourse);
	}
}
