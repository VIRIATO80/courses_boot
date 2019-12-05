package com.viriato.courses.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.viriato.courses.CoursesApplication;
import com.viriato.courses.services.CoursesService;

@ContextConfiguration(classes = CoursesApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CoursesController.class)
public class CoursesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CoursesService service;

	
	@Test
	public void getCourses_ShouldReturnCourses() throws Exception {

	      mockMvc.perform(MockMvcRequestBuilders.get("/courses"))
          .andExpect(MockMvcResultMatchers.status().isOk());
	}
}
