package com.viriato.courses.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.viriato.courses.CoursesApplication;


@ContextConfiguration(classes = CoursesApplication.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CoursesControllerTest {

	@Value("${local.server.port}")
	private int port;

	private TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void contextLoads() {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/courses", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}


}




