package com.viriato.courses.mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.viriato.courses.CoursesApplication;
import com.viriato.courses.model.Teacher;

@ContextConfiguration(classes = CoursesApplication.class)
@SpringBootTest
public class TeachersMapperTest {

    @Autowired
    TeacherMapper mapper;

    @Test
    public void getAllTeachers(){
        List<Teacher> teachers = mapper.getAllTeacher();
        assertNotNull(teachers);
        assertNotNull(teachers);
        assertEquals(3, teachers.size());
    }


}
