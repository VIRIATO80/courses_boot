package com.viriato.courses.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	private int courseId;
	private String title;
	private LevelEnum level;
	private int hours;
	private Teacher teacher;
	private boolean active;

	public Course() {}
	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LevelEnum getLevel() {
		return level;
	}

	public void setLevel(LevelEnum level) {
		this.level = level;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@JsonIgnore
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
