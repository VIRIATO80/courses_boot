package com.viriato.courses.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viriato.courses.model.Teacher;
import com.viriato.courses.services.TeacherService;

@Component
public class TeacherManagerImpl implements TeacherManager {

	@Autowired
	private TeacherService teacherService;
		
	@Override
	public List<Teacher> getAllTeachers() {
		return teacherService.getAllTeachers();
	}

}
