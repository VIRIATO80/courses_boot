package com.viriato.courses.dtos;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.viriato.courses.model.LevelEnum;

public class CourseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(access = Access.READ_ONLY)
	private int courseId;

	@NotBlank(message = "The title of the course is mandatory")
	private String title;

	private LevelEnum level;

	@NotNull(message = "Teacher Id is mandatory")
	@Min(value = 1, message = "Teacher Id is invalid")
	private int teacherId;

	@JsonInclude(value = Include.NON_NULL)
	private String teacherName;

	private int hours;

	@JsonProperty(access = Access.WRITE_ONLY)
	private boolean active;

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

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

}
