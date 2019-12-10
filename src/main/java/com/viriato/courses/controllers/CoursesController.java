package com.viriato.courses.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

import com.viriato.courses.dtos.CourseDTO;
import com.viriato.courses.managers.CoursesManager;


@Component
@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoursesController {
	
	private CoursesManager coursesManager;
	
	public CoursesController(CoursesManager manager) {
		coursesManager = manager;
	}

	@GET
	public List<CourseDTO> courses(	@QueryParam("order") String orderTitle) {
		return coursesManager.getAllCourses(orderTitle);
	}
	
	@POST
	public Response addCourse(@Valid CourseDTO courseDTO) {
		coursesManager.addCourse(courseDTO);
		return Response.status(Status.CREATED).entity(courseDTO).build();
	}
}