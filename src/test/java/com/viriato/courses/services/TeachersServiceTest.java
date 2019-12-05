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

import com.viriato.courses.mappers.TeacherMapper;
import com.viriato.courses.model.Teacher;


public class TeachersServiceTest {
	
	
	@Mock
	private TeacherMapper mapper;

	private TeacherService service;
	
	List<Teacher> teachers = new ArrayList<Teacher>();
	
	
   @BeforeEach
   public void initMocks() {
       MockitoAnnotations.initMocks(this);
       service = new TeacherServiceImpl(mapper);
       Teacher validTeacher = new Teacher();
       validTeacher.setTeacherId(4);
       validTeacher.setName("Rebeca Rabbit");
       teachers.add(validTeacher);
   }
	   
	   
	@Test
	public void getAllTeacher_should_return_list() throws Exception {
		given(mapper.getAllTeachers()).willReturn(teachers);
		List<Teacher> teachers = service.getAllTeachers();
		assertNotNull(teachers);
		assertThat(teachers.size(), is(1));
		assertThat(teachers.get(0).getName()).isEqualTo("Rebeca Rabbit");
		assertThat(teachers.get(0).getTeacherId()).isEqualTo(4);
	}
}

