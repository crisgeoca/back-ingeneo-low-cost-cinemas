package com.ingeneo.cinemas.impl;

import java.util.Optional;

import com.ingeneo.cinemas.bodies.CinemaBranchRequestBody;
import com.ingeneo.cinemas.entities.CinemaBranch;
import com.ingeneo.cinemas.entities.City;
import com.ingeneo.cinemas.entities.Manager;
import com.ingeneo.cinemas.interfaces.CinemaBranchService;
import com.ingeneo.cinemas.repositories.CinemaBranchRepository;
import com.ingeneo.cinemas.repositories.CityRepository;
import com.ingeneo.cinemas.repositories.ManagerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CinemaBranchServiceImpl implements CinemaBranchService{
	
	private static final String MANAGER_NOT_FOUND = "No se encontro el Administrador con id %s";
	private static final String CITY_NOT_FOUND = "No existe la ciudad con id %s";
	
	private final CinemaBranchRepository cinemaBranchRepository;
	private final ManagerRepository managerRepository;
	private final CityRepository cityRepository;

	@Override
	public void saveCinemaBranch(CinemaBranchRequestBody cinemaBranchRequestBody) throws Exception {
		
		cinemaBranchRepository.save(CinemaBranch.builder()
				.name(cinemaBranchRequestBody.getName())
				.address(cinemaBranchRequestBody.getAddress())
				.city(getCity(cinemaBranchRequestBody.getCity()))
				.manager(getManager(cinemaBranchRequestBody.getManager()))
				.build());
		
	}
	
	private Manager getManager(String id) throws Exception {
		Optional<Manager> manager = managerRepository.findById(id);
		if(!manager.isPresent()) {
			throw new Exception(String.format(MANAGER_NOT_FOUND, id));
		}
		return manager.get();
		
	}
	
	private City getCity(Long id) throws Exception {
		Optional<City> city = cityRepository.findById(id);
		if(!city.isPresent()) {
			throw new Exception(String.format(CITY_NOT_FOUND, id));
		}
		return city.get();
		
	}

}
