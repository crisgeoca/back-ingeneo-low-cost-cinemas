package com.ingeneo.cinemas.bodies;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@ApiModel(description = "Ciudad que se desea grabar")
public class CityRequestBody {

	@ApiModelProperty(notes = "Nombre de la ciudad", example = 
			"Medellin", required = true, position = 0)
	private String name;

	@ApiModelProperty(notes = "Departamento al cual pertenece la ciudad", example = 
			"Antioquia", required = true, position = 1)
	private String department; 

}
