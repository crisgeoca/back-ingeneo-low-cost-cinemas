package com.ingeneo.cinemas.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.cinemas.bodies.CinemaBranchRequestBody;
import com.ingeneo.cinemas.interfaces.CinemaBranchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(description = "API para la administracion de sucursales")
public class CinemaBranchController {
	
	private static final Logger LOGGER = LogManager.getLogger(CinemaBranchController.class);
	
	private static final String SUCCESS = "Sucursal grabada con exito";
	
	private final CinemaBranchService cinemaBranchService;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SUCCESS)
	})
	@PostMapping (path = "/saveBranch")
	public ResponseEntity<?> saveBranch(@ApiParam("Endpoint para grabar sucursales") 
	@RequestBody CinemaBranchRequestBody cinemaBranchRequestBody){
		
		try {
			cinemaBranchService.saveCinemaBranch(cinemaBranchRequestBody);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			LOGGER.error("No fue posible grabar la sucursal - Causa: {}", e.getMessage());			
		}
		return ResponseEntity.badRequest().build();
	}

}
