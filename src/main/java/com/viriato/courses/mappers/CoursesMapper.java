package com.viriato.courses.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.One;

import com.viriato.courses.model.Course;
import com.viriato.courses.model.Teacher;


@Mapper
public interface CoursesMapper {

    @Select("SELECT c.courseId, c.title, c.level, c.hours, c.teacherId, c.active FROM COURSES c")
    @Results(value = {
                @Result(property = "courseId", column = "courseId"),
                @Result(property = "title", column = "title"),
                @Result(property = "level", column = "level"),
                @Result(property = "hours", column = "hours"),
                @Result(property = "teacher", javaType= Teacher.class, column = "teacherId", one = @One(select = "getTeacher", fetchType = FetchType.EAGER)),
                @Result(property = "active", column = "active")
            })
	public List<Course> getAllCourses(); 
    
    
	@Select("select * from teachers where teacherId=#{id}")
    @Results(value = {
            @Result(property = "teacherId", column = "teacherId"),
            @Result(property = "name", column = "name")
        })
	public Teacher getTeacher(Integer id);

}
