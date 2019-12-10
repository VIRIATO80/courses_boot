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
       validCourse.setTitle("Curso A");
       validCourse.setActive(true);
       validCourse.setHours(10);
       validCourse.setCourseId(1);
       validCourse.setLevel(LevelEnum.Avanzado);
       courses.add(validCourse);
       
       Course course2 = new Course();
       course2.setTitle("Curso B");
       course2.setActive(true);
       course2.setHours(10);
       course2.setCourseId(1);
       course2.setLevel(LevelEnum.Intermedio);
       courses.add(course2);
   }
	   
	   
	@Test
	public void getAllCourses_should_return_list() throws Exception {
		// GIVEN
		given(mapper.getAllCourses()).willReturn(courses);
		// WHEN
		courses = service.getAllCourses(null);
		// THEN
		assertNotNull(courses);
		assertThat(courses.size(), is(2));
		assertThat(courses.get(0).getTitle()).isEqualTo("Curso A");
		assertThat(courses.get(0).isActive()).isEqualTo(true);
		assertThat(courses.get(0).getCourseId()).isEqualTo(1);
		assertThat(courses.get(0).getHours()).isEqualTo(10);
		assertThat(courses.get(0).getLevel()).isEqualTo(LevelEnum.Avanzado);
	}
	
	
	@Test
	public void getAllCourses_should_return_only_active() throws Exception {
		// GIVEN
		given(mapper.getAllCourses()).willReturn(courses);
		// WHEN
		courses = service.getAllCourses(null);
		// THEN
		assertNotNull(courses);
		assertThat(courses.size(), is(2));
		assertThat(courses.get(0).isActive()).isEqualTo(true);
		assertThat(courses.get(1).isActive()).isEqualTo(true);
	}
}
