package com.viriato.courses.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viriato.courses.model.Course;
import com.viriato.courses.services.CoursesService;


@Component
@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoursesController {
	
	
	private CoursesService coursesService;
	
	@Autowired
	public CoursesController(CoursesService service) {
		coursesService = service;
	}
	
	@GET
	public List<Course> courses() {
		return coursesService.getAllCourses();
	}
}