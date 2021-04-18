package com.ingeneo.cinemas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.cinemas.bodies.CityRequestBody;
import com.ingeneo.cinemas.interfaces.CityInterface;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(description = "API para la administracion de ciudades")
public class CityController {	

	private static final String SUCCESS = "Ciudad grabada con exito";

	private final CityInterface cityInterface;

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SUCCESS)
	})
	@PostMapping (path = "/saveCity")
	public ResponseEntity<?> saveCity(@ApiParam("Endpoint para grabar ciudades") 
	@RequestBody CityRequestBody cityRequestBody){
		cityInterface.saveCity(cityRequestBody);
		return ResponseEntity.ok().build();
	}

}
