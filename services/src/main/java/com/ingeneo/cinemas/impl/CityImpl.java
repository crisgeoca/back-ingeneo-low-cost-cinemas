package com.ingeneo.cinemas.impl;

import com.ingeneo.cinemas.bodies.CityRequestBody;
import com.ingeneo.cinemas.entities.City;
import com.ingeneo.cinemas.interfaces.CityInterface;
import com.ingeneo.cinemas.repositories.CityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CityImpl implements CityInterface{
	
	private final CityRepository cityRepository;
	
	@Override
	public void saveCity(CityRequestBody cityRequestBody) {
		
		cityRepository.save(City.builder()
				.name(cityRequestBody.getName())
				.department(cityRequestBody.getDepartment())
				.build());		
	}

}
