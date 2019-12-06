package com.viriato.courses.model;

import java.io.Serializable;

public class Teacher implements Serializable {

	private static final long serialVersionUID = 1L;

	private int teacherId;
	private String teacherName;

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}




}
