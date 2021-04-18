package com.ingeneo.cinemas.dto;

import java.util.List;

import com.ingeneo.cinemas.entities.CinemaBranch;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CityDTO {
	
	private Long id;
	
	private String name;
	
	private String department; 
	
	private List<CinemaBranch> cinemaBranch;

}
