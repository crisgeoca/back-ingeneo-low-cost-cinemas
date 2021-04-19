package com.ingeneo.cinemas.dto;

import com.ingeneo.cinemas.entities.CinemaBranch;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ManagerDTO {
	
	private String identificationNumber;
	
	private String name;
	
	private String phoneNumber;
	
	private CinemaBranch cinemaBranch;

}
