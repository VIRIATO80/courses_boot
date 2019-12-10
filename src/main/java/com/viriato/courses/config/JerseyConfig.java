package com.viriato.courses.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.annotation.Configuration;

import com.viriato.courses.controllers.CoursesController;
import com.viriato.courses.controllers.TeachersController;
import com.viriato.courses.errorhandling.BadRequestExceptionMapper;
import com.viriato.courses.errorhandling.GenericExceptionMapper;


@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        
    	//Register resources
        register(CoursesController.class);
        register(TeachersController.class);
        
        //register exception handlers
        register(BadRequestExceptionMapper.class);
		register(GenericExceptionMapper.class);
		
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }
}
