package com.ingeneo.cinemas.bodies;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@ApiModel(description = "Administrador que se desea grabar")
public class ManagerRequestBody {

	@ApiModelProperty(notes = "Cedula de ciudadania del administrador", example = 
			"123456789", required = true, position = 0)
	private String identificationNumber;

	@ApiModelProperty(notes = "Nombre completo del administrador", example = 
			"Juan Luis Guerra", required = true, position = 1)
	private String name;

	@ApiModelProperty(notes = "Telefono del Administrador", example = 
			"3001234567", required = true, position = 2)
	private String phoneNumber;

}
