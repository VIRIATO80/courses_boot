package com.viriato.courses.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.viriato.courses.CoursesApplication;
import com.viriato.courses.dtos.CourseDTO;
import com.viriato.courses.model.Course;
import com.viriato.courses.model.LevelEnum;
import com.viriato.courses.model.Teacher;

@ContextConfiguration(classes = CoursesApplication.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CoursesControllerTest {

	@Value("${local.server.port}")
	private int port;

	private TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testEndpoint_Courses() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("http://localhost:" + this.port + "/courses",
				String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test
	public void testEndpoint_Teachers() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("http://localhost:" + this.port + "/teachers",
				String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test
	public void testEndpoint_Levels() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("http://localhost:" + this.port + "/levels",
				String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test
	public void getCourses_should_Return_list() {
		ResponseEntity<Course[]> response = this.restTemplate.getForEntity("http://localhost:" + this.port + "/courses",
				Course[].class);
		// assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).hasSize(2);
		assertThat(response.getBody()[0].getCourseId()).isEqualTo(1);
	}

	@Test
	public void addCourse_should_Return_newCourse() throws Exception {

		CourseDTO validCourse = new CourseDTO();
		validCourse.setTitle("Curso 1");
		validCourse.setActive(true);
		validCourse.setHours(10);
		validCourse.setTeacherId(1);
		validCourse.setLevel(LevelEnum.Avanzado);

		URI uri = new URI("http://localhost:" + this.port + "/courses");
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<CourseDTO> request = new HttpEntity<>(validCourse, headers);
		ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
		// assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
	
	@Test
	public void addBadCourse_should_return_BadRequestCode() throws Exception {

		CourseDTO validCourse = new CourseDTO();
		validCourse.setTitle("Curso 1");
		validCourse.setActive(true);
		validCourse.setHours(10);

		URI uri = new URI("http://localhost:" + this.port + "/courses");
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<CourseDTO> request = new HttpEntity<>(validCourse, headers);
		ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
		// assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void addCourse_with_invalid_teacher_should_return_Error500Code() throws Exception {

		CourseDTO validCourse = new CourseDTO();
		validCourse.setTitle("Curso 1");
		validCourse.setActive(true);
		validCourse.setHours(10);
		validCourse.setTeacherId(7);

		URI uri = new URI("http://localhost:" + this.port + "/courses");
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<CourseDTO> request = new HttpEntity<>(validCourse, headers);
		ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
		// assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}	

	@Test
	public void getTeachers_should_Return_list() {
		ResponseEntity<Teacher[]> response = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/teachers", Teacher[].class);
		// assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).hasSize(3);
		assertThat(response.getBody()[0].getTeacherId()).isEqualTo(1);
	}

	@Test
	public void getLevels_should_Return_list() {
		ResponseEntity<String[]> response = this.restTemplate.getForEntity("http://localhost:" + this.port + "/levels",
				String[].class);
		// assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).hasSize(3);
		assertThat(response.getBody()[0]).isEqualTo("Principiante");
	}

}
