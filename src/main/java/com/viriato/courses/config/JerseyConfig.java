package com.viriato.courses.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.viriato.courses.controllers.CoursesController;
import com.viriato.courses.controllers.TeachersController;


@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        
        register(CoursesController.class);
        register(TeachersController.class);
    }
}
