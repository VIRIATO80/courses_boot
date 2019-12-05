package com.viriato.courses.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.viriato.courses.model.Course;
import com.viriato.courses.model.Teacher;


@Mapper
public interface CoursesMapper {

	
    @Select("SELECT c.courseId, c.title, c.level, c.hours, c.teacherId FROM COURSES c where c.active = true")
    @Results(value = {
                @Result(property = "courseId", column = "courseId"),
                @Result(property = "title", column = "title"),
                @Result(property = "level", column = "level"),
                @Result(property = "hours", column = "hours"),
                @Result(property = "teacher", javaType= Teacher.class, column = "teacherId", one = @One(select = "getTeacher", fetchType = FetchType.EAGER))
            })
    public List<Course> getAllCourses(); 
    
    
	@Select("select * from teachers where teacherId=#{id}")
    @Results(value = {
            @Result(property = "teacherId", column = "teacherId"),
            @Result(property = "name", column = "name")
        })
	public Teacher getTeacher(Integer id);

	
	
	@Insert("INSERT into COURSES(title, level, hours, teacherId, active) "
			+ "VALUES(#{title}, #{level},#{hours}, #{teacher.teacherId}, #{active})")
	public void addCourse(Course course);
	
    @Select("SELECT * FROM COURSES c where c.title = #{title}")
    public Course getCourseByTitle(String title); 
	

}
