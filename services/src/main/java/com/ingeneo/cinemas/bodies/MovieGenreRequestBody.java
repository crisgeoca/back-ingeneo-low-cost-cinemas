package com.ingeneo.cinemas.bodies;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ApiModel(description = "Genero de la pelicula que se desea crear")
public class MovieGenreRequestBody {
	
	@ApiModelProperty(notes = "Genero", example = 
			"Accion", required = true, position = 0)
	private String description;

}
