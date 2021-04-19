package com.ingeneo.cinemas.impl;

import com.ingeneo.cinemas.bodies.CityRequestBody;
import com.ingeneo.cinemas.entities.City;
import com.ingeneo.cinemas.interfaces.CityService;
import com.ingeneo.cinemas.repositories.CityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CityServiceImpl implements CityService{
	
	private final CityRepository cityRepository;
	
	@Override
	public void saveCity(CityRequestBody cityRequestBody) {
		
		cityRepository.save(City.builder()
				.name(cityRequestBody.getName())
				.department(cityRequestBody.getDepartment())
				.build());		
	}

}
