package com.viriato.courses.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.viriato.courses.model.Teacher;

@Mapper
public interface TeacherMapper {
	
	@Select("select * from teachers where teacherId=#{id}")
    @Results(value = {
            @Result(property = "teacherId", column = "teacherId"),
            @Result(property = "name", column = "name")
        })
	public Teacher getTeacher(Integer id);
}
