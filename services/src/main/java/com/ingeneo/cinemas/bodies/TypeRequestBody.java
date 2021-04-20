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
@ApiModel(description = "Tipo de sala y formato de pelicula que se desea grabar")
public class TypeRequestBody {
	
	@ApiModelProperty(notes = "Tipo de sala/formato de pelicula ", example = 
			"2D", required = true, position = 0)
	private String description;

}
