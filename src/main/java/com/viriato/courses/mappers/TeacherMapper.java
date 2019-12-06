package com.viriato.courses.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.viriato.courses.model.Teacher;

@Mapper
public interface TeacherMapper {
	
	@Select("select * from teachers")
	public List<Teacher> getAllTeachers();
}
