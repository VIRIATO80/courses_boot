package com.viriato.courses.mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.viriato.courses.model.Course;
import com.viriato.courses.model.LevelEnum;
import com.viriato.courses.model.Teacher;


@ExtendWith(SpringExtension.class)
@MybatisTest

public class CoursesMapperTest {

    @Autowired
    CoursesMapper mapper;
    
    @Test
    public void getAllCourses(){
        List<Course> list = mapper.getAllCourses();
        assertNotNull(list);
        assertEquals(2, list.size());
    }

    
    @Test
    public void getFirstTeacher(){
        Teacher teacher = mapper.getTeacher(1);
        assertNotNull(teacher);
        assertEquals(teacher.getName(), "Pedro Pony");
        assertEquals(teacher.getTeacherId(), 1);
    }
    
    @Test
    public void testInsertNewCourse() {  	
    	Teacher teacher = new Teacher();
    	teacher.setTeacherId(1);
    	Course course = new Course();
    	course.setTitle("Test 1");
    	course.setLevel(LevelEnum.Intermedio);
    	course.setTeacher(teacher);
    	mapper.addCourse(course);
    	Course recordCourse = mapper.getCourseByTitle("Test 1");
    	System.out.println("Curso:" + recordCourse);
    	assertThat(recordCourse).isNotNull();
    }
    
}