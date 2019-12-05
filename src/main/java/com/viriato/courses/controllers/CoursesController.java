package com.viriato.courses.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	@POST
	public Response addCourse(@RequestBody @Valid Course course) {
		int generatedId = coursesService.addCourse(course);
		course.setCourseId(generatedId);
		return Response.status(Status.CREATED).entity(course).build();
	}
}