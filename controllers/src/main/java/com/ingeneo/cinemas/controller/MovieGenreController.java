package com.ingeneo.cinemas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.cinemas.bodies.MovieGenreRequestBody;
import com.ingeneo.cinemas.interfaces.MovieGenreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(description = "API para la administracion de generos de una pelicula")
public class MovieGenreController {
	
	private static final String SUCCESS = "Genero creado con exito";
	
	private final MovieGenreService movieGenreService;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SUCCESS)
	})
	@PostMapping (path = "/saveGenre")
	public ResponseEntity<?> saveGenre(@ApiParam("Endpoint para grabar generos") 
	@RequestBody MovieGenreRequestBody movieGenreRequestBody){
		
		movieGenreService.saveMovieGenre(movieGenreRequestBody);
		return ResponseEntity.ok().build();		
	}

}
