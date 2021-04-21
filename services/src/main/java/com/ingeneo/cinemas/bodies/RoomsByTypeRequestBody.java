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
@ApiModel(description = "Tipo de formato")
public class RoomsByTypeRequestBody {
	
	@ApiModelProperty(notes = "Tipo de formato", example = 
			"2D", required = true, position = 0)
	private String type;

}
