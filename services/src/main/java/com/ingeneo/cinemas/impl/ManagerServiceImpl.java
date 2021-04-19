package com.ingeneo.cinemas.impl;

import com.ingeneo.cinemas.bodies.ManagerRequestBody;
import com.ingeneo.cinemas.entities.Manager;
import com.ingeneo.cinemas.interfaces.ManagerService;
import com.ingeneo.cinemas.repositories.ManagerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService{
	
	private final ManagerRepository managerRepository;

	@Override
	public void saveManager(ManagerRequestBody managerRequestBody) {
		
		managerRepository.save(Manager.builder()
				.identificationNumber(managerRequestBody.getIdentificationNumber())
				.name(managerRequestBody.getName())
				.phoneNumber(managerRequestBody.getPhoneNumber())
				.build());
		
	}

}
