package com.viriato.courses.controllers;

import java.lang.reflect.Type;
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

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viriato.courses.dtos.CourseDTO;
import com.viriato.courses.model.Course;
import com.viriato.courses.services.CoursesService;


@Component
@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoursesController {
	
	private CoursesService coursesService;
	
    @Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	public CoursesController(CoursesService service) {
		coursesService = service;
	}
	
	@GET
	public List<CourseDTO> courses() {
		Type listType = new TypeToken<List<CourseDTO>>(){}.getType();
		return modelMapper.map(coursesService.getAllCourses(), listType);
	}
	
	@POST
	public Response addCourse(@Valid CourseDTO courseDTO) {
		Course course = modelMapper.map(courseDTO , Course.class);
		coursesService.addCourse(course);
		courseDTO.setCourseId(course.getCourseId());
		return Response.status(Status.CREATED).entity(courseDTO).build();
	}
}