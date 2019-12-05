package com.viriato.courses.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.One;

import com.viriato.courses.model.Course;


@Mapper
public interface CoursesMapper {

    @Select("SELECT * FROM COURSES c")
    @Results(value = {
                @Result(property = "courseId", column = "courseId"),
                @Result(property = "title", column = "title"),
                @Result(property = "level", column = "level"),
                @Result(property = "hours", column = "hours"),
                @Result(property = "teacher", column = "teacher", one = @One(select = "getTeacher")),
                @Result(property = "active", column = "active")
            })
	public List<Course> getAllCourses(); 

}
