package com.viriato.courses.mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.viriato.courses.CoursesApplication;
import com.viriato.courses.model.Course;
import com.viriato.courses.model.Teacher;


@ContextConfiguration(classes = CoursesApplication.class)
@SpringBootTest
public class CoursesMapperTest {

    @Autowired
    CoursesMapper mapper;

    
    @Test
    public void getAllCourses(){
        List<Course> list = mapper.getAllCourses();
        assertNotNull(list);
        assertEquals(3, list.size());
    }

    
    @Test
    public void getFirstTeacher(){
        Teacher teacher = mapper.getTeacher(1);
        assertNotNull(teacher);
        assertEquals(teacher.getName(), "Pedro Pony");
        assertEquals(teacher.getTeacherId(), 1);
    }
    
}