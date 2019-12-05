package com.viriato.courses.controllers;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.viriato.courses.model.LevelEnum;

@Component
@Path("/levels")
@Produces(MediaType.APPLICATION_JSON)
public class LevelsController {

	@GET
	public LevelEnum[] teacher() {
		return LevelEnum.values();
	}
	
}
