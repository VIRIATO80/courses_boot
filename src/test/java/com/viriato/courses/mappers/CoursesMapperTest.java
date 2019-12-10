package com.viriato.courses.mappers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

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

	//solo se mostrarán los cursos marcados como activos
	@Test
	public void list_should_only_show_courses_active() {
		//When
		List<Course> list = mapper.getAllCourses();
		//Then
		assertNotNull(list);
		assertEquals(4, list.size());
		assertThat(list, everyItem(hasProperty("active", is(true))));	
	}
	
	/*el listado mostrará el título del curso, el nivel, el número de horas
	del mismo y el profesor*/
	@Test
	public void list_should__show_all_parameter() {
		//When
		List<Course> list = mapper.getAllCourses();
		//Then
		assertThat(list, everyItem(hasProperty("title")));	
		assertThat(list, everyItem(hasProperty("level")));
		assertThat(list, everyItem(hasProperty("hours")));	
		assertThat(list, everyItem(hasProperty("teacher")));	
		assertThat(list, everyItem(hasProperty("active")));	
	}
	
	//se deberá ordenar la tabla por la columna del título de curso (Ascendente)
	@Test
	public void list_should_be_orderby_title_asc() {
		//When
		List<Course> list = mapper.getCoursesByTitleAsc();
		//Then
		assertThat(list.get(0), hasProperty("title", is("Angular Principles")));	
	}
	
	//se deberá ordenar la tabla por la columna del título de curso (Descendente)
	@Test
	public void list_should_be_orderby_title_desc() {
		//When
		List<Course> list = mapper.getCoursesByTitleDesc();
		//Then
		assertThat(list.get(0), hasProperty("title", is("Spring Framework")));	
	}

	//como usuario quiero poder dar de alta nuevos cursos
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
	
	//Se lanza excepción cuando uno de los atributos obligatorios del curso faltan
	@Test
	public void badCourseInsert_should_throwsException() {
		Course course = new Course();
		course.setLevel(LevelEnum.Intermedio);
		assertThrows(DataIntegrityViolationException.class,() -> mapper.addCourse(course));
	}
	
	//Probando la obtención del mapper de profesores getTeacher
	@Test
	public void getFirstTeacher() {
		Teacher teacher = mapper.getTeacherById(1);
		assertNotNull(teacher);
		assertEquals(teacher.getTeacherName(), "Pedro Pony");
		assertEquals(teacher.getTeacherId(), 1);
	}

}