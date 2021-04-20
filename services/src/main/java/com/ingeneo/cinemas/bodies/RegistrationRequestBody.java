package com.ingeneo.cinemas.bodies;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@ToString
@ApiModel(description = "Registro de un usuario")
public class RegistrationRequestBody {
	
	@ApiModelProperty(notes = "Cedula de ciudadania del usuario", example = 
			"123456789", required = true, position = 0)
	private String identificationNumber;
	
	@ApiModelProperty(notes = "Nombre del usuario", example = 
			"Juan Luis Guerra", required = true, position = 1)
	private String name;
	
	@ApiModelProperty(notes = "Correo del usuario", example = 
			"crisgeoca@hotmail.com", required = true, position = 2)
	private String email;
	
	@ApiModelProperty(notes = "Contraseña del usuario", example = 
			"juan123", required = true, position = 3)
	private String password;
	
	@ApiModelProperty(notes = "Telefono del usuario", example = 
			"3201234567", required = true, position = 4)
	private String phoneNumber;

}
