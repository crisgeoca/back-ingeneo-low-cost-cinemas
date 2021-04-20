package com.ingeneo.cinemas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.cinemas.bodies.RegistrationRequestBody;
import com.ingeneo.cinemas.interfaces.RegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(description = "API para realizar el registro de usuarios")
public class RegistrationController {
	
	private static final String SUCCESS = "Usuario grabado con exito";
	
	private final RegistrationService registrationService;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SUCCESS)
	})
	@PostMapping (path = "/saveUser")
	public String registerUser(@ApiParam("Endpoint para registrar usuarios") 
	@RequestBody RegistrationRequestBody registrationRequestBody) {
		
		return registrationService.registerUser(registrationRequestBody);
		
	}
	
	@GetMapping(path = "/confirm")
    public String confirm(@ApiParam("Endpoint para confirmar registro de usuarios") 
    @RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
