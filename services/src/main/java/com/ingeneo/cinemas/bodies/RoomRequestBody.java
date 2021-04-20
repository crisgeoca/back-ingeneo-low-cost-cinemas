package com.ingeneo.cinemas.bodies;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@ApiModel(description = "Sala que se desea crear")
public class RoomRequestBody {
	
	@ApiModelProperty(notes = "ID tipo de sala", example = 
			"1", required = true, position = 0)
	private Long type;
	
	@ApiModelProperty(notes = "Numero de filas de la sala", example = 
			"3", required = true, position = 1)
	private int rowsNumber;
	
	@ApiModelProperty(notes = "Numero de sillas por fila", example = 
			"3", required = true, position = 2)
	private int maxRowsNumber;
	
	@ApiModelProperty(notes = "ID de la sucursal", example = 
			"1", required = true, position = 3)
	private Long cinemaBranch;

}
