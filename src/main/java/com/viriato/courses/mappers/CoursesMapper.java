package com.viriato.courses.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.viriato.courses.model.Course;
import com.viriato.courses.model.Teacher;

@Mapper
public interface CoursesMapper {

	@Select("SELECT c.courseId, c.title, c.level, c.hours, c.teacherId, c.active FROM COURSES c where c.active = true ")
	@Results(value = { 
			@Result(property = "teacher", javaType = Teacher.class, column = "teacherId", one = @One(select = "getTeacherById", fetchType = FetchType.EAGER)) 
	})
	public List<Course> getAllCourses();
	
	
	@Select("SELECT c.courseId, c.title, c.level, c.hours, c.teacherId, c.active FROM COURSES c where c.active = true order by c.title asc")
	@Results(value = { 
			@Result(property = "teacher", javaType = Teacher.class, column = "teacherId", one = @One(select = "getTeacherById", fetchType = FetchType.EAGER)) 
	})
	public List<Course> getCoursesByTitleAsc();

	
	@Select("SELECT c.courseId, c.title, c.level, c.hours, c.teacherId, c.active FROM COURSES c where c.active=true order by c.title desc")
	@Results(value = { 
			@Result(property = "teacher", javaType = Teacher.class, column = "teacherId", one = @One(select = "getTeacherById", fetchType = FetchType.EAGER)) 
	})
	public List<Course> getCoursesByTitleDesc();
	
	
	@Select("select * from teachers where teacherId=#{id}")
	public Teacher getTeacherById(Integer id);

	
	@Insert("INSERT into COURSES(courseId, title, level, hours, teacherId, active) "
			+ "VALUES(null, #{title}, #{level},#{hours}, #{teacher.teacherId}, #{active})")
	@Options(useGeneratedKeys = true, keyColumn = "courseId", keyProperty = "courseId")
	public int addCourse(Course course);
	
}
