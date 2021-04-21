package com.ingeneo.cinemas.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.cinemas.bodies.MovieRequestBody;
import com.ingeneo.cinemas.interfaces.MovieService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(description = "API para la administracion de peliculas")
public class MovieController {
	
	private static final Logger LOGGER = LogManager.getLogger(MovieController.class);
	
	private static final String SUCCESS = "Pelicula creada con exito";
	
	private final MovieService movieService;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SUCCESS)
	})
	@PostMapping (path = "/saveMovie")
	public ResponseEntity<?> saveMovie(@ApiParam("Endpoint para grabar salas") 
	@RequestBody MovieRequestBody movieRequestBody){
		
		try {
			movieService.saveMovie(movieRequestBody);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return ResponseEntity.badRequest().build();		
	}
}
