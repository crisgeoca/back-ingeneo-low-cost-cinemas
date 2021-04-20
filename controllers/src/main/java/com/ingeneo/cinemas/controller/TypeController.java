package com.ingeneo.cinemas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.cinemas.bodies.TypeRequestBody;
import com.ingeneo.cinemas.interfaces.TypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(description = "API para la administracion de tipos de salas y formatos de peliculas")
public class TypeController {
	
	private static final String SUCCESS = "Tipo de sala grabada con exito";
	
	private final TypeService typeService;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SUCCESS)
	})
	@PostMapping (path = "/saveType")
	public ResponseEntity<?> saveType(@ApiParam("Endpoint para grabar tipos de salas y formatos de peliculas") 
	@RequestBody TypeRequestBody typeRequestBody){
		typeService.saveType(typeRequestBody);
		return ResponseEntity.ok().build();
	}

}
