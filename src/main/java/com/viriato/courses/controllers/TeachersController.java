package com.viriato.courses.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viriato.courses.model.Teacher;
import com.viriato.courses.services.TeacherService;

@Component
@Path("/teachers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeachersController {

	private TeacherService teacherService;
	
	@Autowired
	public TeachersController(TeacherService service) {
		teacherService = service;
	}
	
	@GET
	public List<Teacher> teacher() {
		return teacherService.getAllTeachers();
	}
}
