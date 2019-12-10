package com.viriato.courses.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.viriato.courses.managers.TeacherManager;
import com.viriato.courses.model.Teacher;

@Component
@Path("/teachers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeachersController {

	private TeacherManager teacherManager;
	
	public TeachersController(TeacherManager manager) {
		teacherManager = manager;
	}
	
	@GET
	public List<Teacher> teacher() {
		return teacherManager.getAllTeachers();
	}
}
