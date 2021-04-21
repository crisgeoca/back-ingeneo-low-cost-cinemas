package com.ingeneo.cinemas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.cinemas.bodies.MovieScheduleRequestBody;
import com.ingeneo.cinemas.interfaces.MovieScheduleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequiredArgsConstructor
@Api(description = "API para la administracion y agenda de peliculas")
public class MovieScheduleController {
	
	private static final Logger LOGGER = LogManager.getLogger(MovieScheduleController.class);
	
	private static final String SUCCESS = "Pelicula agendada con exito";
	
	private final MovieScheduleService movieScheduleService;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SUCCESS)
	})
	@PostMapping (path = "/saveMovieSchedule")
	public ResponseEntity<?> saveMovieSchedule(@ApiParam("Endpoint para agendar peliculas") 
	@RequestBody MovieScheduleRequestBody movieScheduleRequestBody){
		try {
			movieScheduleService.scheduleMovie(movieScheduleRequestBody);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			LOGGER.error("No fue posible agendar la pelicula - Causa: {}", e.getMessage());
		}
		return ResponseEntity.badRequest().build();		
	}

}
