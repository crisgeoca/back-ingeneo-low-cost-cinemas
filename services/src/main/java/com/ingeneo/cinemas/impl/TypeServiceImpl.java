package com.ingeneo.cinemas.impl;

import com.ingeneo.cinemas.bodies.TypeRequestBody;
import com.ingeneo.cinemas.entities.Type;
import com.ingeneo.cinemas.interfaces.TypeService;
import com.ingeneo.cinemas.repositories.TypeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService{
	
	private final TypeRepository typeRepository;

	@Override
	public void saveType(TypeRequestBody typeRequestBody) {
		typeRepository.save(Type.builder()
				.description(typeRequestBody.getDescription())
				.build());
		
	}

}
