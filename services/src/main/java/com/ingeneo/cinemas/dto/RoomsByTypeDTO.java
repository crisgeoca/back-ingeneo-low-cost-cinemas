package com.ingeneo.cinemas.dto;

import com.ingeneo.cinemas.entities.CinemaBranch;
import com.ingeneo.cinemas.entities.Type;

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
public class RoomsByTypeDTO {
	
	private Long id;
	
	private Type type;
	
	private int rowsNumber;
	
	private int maxChairsNumber;
	
	private CinemaBranch cinemaBranch;

}
