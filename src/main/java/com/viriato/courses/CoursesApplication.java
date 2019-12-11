package com.viriato.courses;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoursesApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(CoursesApplication.class, args);
	}
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CoursesApplication.class);
    }

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
