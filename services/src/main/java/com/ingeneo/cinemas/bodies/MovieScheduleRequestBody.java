package com.ingeneo.cinemas.bodies;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@ApiModel(description = "Programacion de la pelicula")
public class MovieScheduleRequestBody {
	
	@ApiModelProperty(notes = "ID de la pelicula quue se desea agendar", example = 
			"7", required = true, position = 0)
	private String movie;
	
	@ApiModelProperty(notes = "Fecha de presentacion de la pelicula", example = 
			"2021-07-20T15:53:16", required = true, position = 1)
	private LocalDateTime scheduledDate;
	
	@ApiModelProperty(notes = "ID de la sala donde se presentara la pelicula", example = 
			"Avengers", required = true, position = 2)
	private String room;

}
