package com.viriato.courses.mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	public void getAllCoursesActives() {
		List<Course> list = mapper.getAllCourses();
		assertNotNull(list);
		assertEquals(4, list.size());
	}

	
	@Test
	public void getLastCourse_with_page() {
		//Num of init, num of records
		RowBounds conf = new RowBounds(3, 5);
		List<Course> list = mapper.getCoursesOfPage(conf);
		assertNotNull(list);
		assertEquals(1, list.size());
	}
	
	@Test
	public void getFirstTeacher() {
		Teacher teacher = mapper.getTeacher(1);
		assertNotNull(teacher);
		assertEquals(teacher.getTeacherName(), "Pedro Pony");
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
		int newId= mapper.addCourse(course);
		assertEquals(newId, 1);
	}
	
	@Test
	public void badCourseInsert_should_throwsException() {
		Course course = new Course();
		course.setLevel(LevelEnum.Intermedio);
		assertThrows(DataIntegrityViolationException.class,() -> mapper.addCourse(course));
	}

}