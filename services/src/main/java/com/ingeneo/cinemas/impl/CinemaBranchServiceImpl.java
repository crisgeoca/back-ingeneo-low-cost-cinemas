package com.ingeneo.cinemas.impl;

import java.util.Optional;

import com.ingeneo.cinemas.bodies.CinemaBranchRequestBody;
import com.ingeneo.cinemas.entities.CinemaBranch;
import com.ingeneo.cinemas.entities.City;
import com.ingeneo.cinemas.entities.Users;
import com.ingeneo.cinemas.enums.UserRole;
import com.ingeneo.cinemas.interfaces.CinemaBranchService;
import com.ingeneo.cinemas.repositories.CinemaBranchRepository;
import com.ingeneo.cinemas.repositories.CityRepository;
import com.ingeneo.cinemas.repositories.LoginRepositiry;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CinemaBranchServiceImpl implements CinemaBranchService{
	
	private static final String MANAGER_NOT_FOUND = "No se encontro el Administrador con id %s";
	private static final String CITY_NOT_FOUND = "No existe la ciudad con id %s";
	
	private final CinemaBranchRepository cinemaBranchRepository;
	private final CityRepository cityRepository;
	private final LoginRepositiry loginRepositiry;

	@Override
	public void saveCinemaBranch(CinemaBranchRequestBody cinemaBranchRequestBody) throws Exception {
		
		cinemaBranchRepository.save(CinemaBranch.builder()
				.name(cinemaBranchRequestBody.getName())
				.address(cinemaBranchRequestBody.getAddress())
				.city(getCity(cinemaBranchRequestBody.getCity()))
				.users(getUser(cinemaBranchRequestBody.getUser()))
				.build());
		
	}
	
	private Users getUser(String id) throws Exception {
		Optional<Users> user = loginRepositiry.findByIdentificationNumberAndUserRole(id, UserRole.ADMIN);
		if(!user.isPresent()) {
			throw new Exception(String.format(MANAGER_NOT_FOUND, id));
		}
		return user.get();
		
	}
	
	private City getCity(Long id) throws Exception {
		Optional<City> city = cityRepository.findById(id);
		if(!city.isPresent()) {
			throw new Exception(String.format(CITY_NOT_FOUND, id));
		}
		return city.get();
		
	}

}
