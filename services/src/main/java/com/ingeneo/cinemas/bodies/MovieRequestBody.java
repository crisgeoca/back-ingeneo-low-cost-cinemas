package com.ingeneo.cinemas.bodies;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@ApiModel(description = "Pelicula que se desea crear")
public class MovieRequestBody {
	
	@ApiModelProperty(notes = "Nombre original de la pelicula", example = 
			"Avengers", required = true, position = 0)
	private String originalName;	
	
	@ApiModelProperty(notes = "Nombre traducido de la pelicula", example = 
			"Vengadores", required = true, position = 1)
	private String translatedName;
	
	@ApiModelProperty(notes = "Fecha de estreno", example = 
			"2021-07-05T15:53:16", required = true, position = 2)
	private LocalDateTime releaseDate;
	
	@ApiModelProperty(notes = "Imagen de la pelicula", example = 
			"Medellin", required = true, position = 3)
    private String moviePic;
	
	@ApiModelProperty(notes = "Fecha de baja de la pelicula", example = 
			"2021-07-20T15:53:16", required = true, position = 4)
	private LocalDateTime finalReleaseDate;
	
	@ApiModelProperty(notes = "Genero de la pelicula", example = 
			"1", required = true, position = 5)
	private List<String> movieGenre;
	
	@ApiModelProperty(notes = "Sinopsis", example = 
			"Pelicula de fantasia", required = true, position = 6)
	private String synopsis;
	
	@ApiModelProperty(notes = "Formato de la pelicula", example = 
			"1", required = true, position = 7)
	private String movieFormat;
	
	@ApiModelProperty(notes = "Duracion en minutos", example = 
			"130", required = true, position = 8)
	private int minutesDuration;
	
	@ApiModelProperty(notes = "Sucursales", example = 
			"1", required = true, position = 9)
    private Set<String> cinemaBranches;

}
