package com.ingeneo.cinemas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.cinemas.bodies.ManagerRequestBody;
import com.ingeneo.cinemas.interfaces.ManagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(description = "API para la administracion de administradores")
public class ManagerController {
	
	private static final String SUCCESS = "Administrador grabado con exito";
	
	private final ManagerService managerService;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SUCCESS)
	})
	@PostMapping (path = "/saveManager")
	public ResponseEntity<?> saveManager(@ApiParam("Endpoint para grabar administradores") 
	@RequestBody ManagerRequestBody managerRequestBody){
		managerService.saveManager(managerRequestBody);
		return ResponseEntity.ok().build();
	}

}
