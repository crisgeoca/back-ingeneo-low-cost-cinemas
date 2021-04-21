package com.ingeneo.cinemas.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.cinemas.bodies.RoomRequestBody;
import com.ingeneo.cinemas.bodies.RoomsByTypeRequestBody;
import com.ingeneo.cinemas.dto.RoomsByTypeDTO;
import com.ingeneo.cinemas.interfaces.RoomService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(description = "API para la administracion de salas")
public class RoomController {
	
	private static final Logger LOGGER = LogManager.getLogger(RoomController.class);	
	private static final String SUCCESS = "Sala creada con exito";
	
	private final RoomService roomService;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SUCCESS)
	})
	@PostMapping (path = "/saveRoom")
	public ResponseEntity<?> saveRoom(@ApiParam("Endpoint para grabar salas") 
	@RequestBody RoomRequestBody roomRequestBody){
		
		try {
			roomService.saveRoom(roomRequestBody);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			LOGGER.error("No fue posible grabar la sucursal - Causa: {}", e.getMessage());			
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping (path = "/getRoomsByType")
	public ResponseEntity<List<RoomsByTypeDTO>> getRoomsByType(@ApiParam("Endpoint para obtener salas por tipo de formato") 
	@RequestBody RoomsByTypeRequestBody roomsByTypeRequestBody){
		
		try {
			return ResponseEntity.ok().body(this.roomService.findAllByType(roomsByTypeRequestBody.getType()));
		} catch (Exception e) {
			LOGGER.error("No fue posible obtener la lista de salas - Causa: {}", e.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}

}
