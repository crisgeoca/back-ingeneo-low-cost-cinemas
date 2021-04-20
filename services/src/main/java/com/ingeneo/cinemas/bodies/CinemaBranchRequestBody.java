package com.ingeneo.cinemas.bodies;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@ApiModel(description = "Sucursal que se desea grabar")
public class CinemaBranchRequestBody {
	
	@ApiModelProperty(notes = "Nombre de la sucursal", example = 
			"Cinema el prado", required = true, position = 0)
	private String name;

	@ApiModelProperty(notes = "Direccion de la sucursal", example = 
			"Avenida los gonzales No 1234", required = true, position = 1)
	private String address;

	@ApiModelProperty(notes = "ID de la ciudad donde se abrira la sucursal", example = 
			"1", required = true, position = 2)
	private Long city;

	@ApiModelProperty(notes = "ID del administrador de la sucursal", example = 
			"123456789", required = true, position = 3)
	private String user;

}
