package com.ingeneo.cinemas.impl;

import java.util.Optional;

import com.ingeneo.cinemas.bodies.RoomRequestBody;
import com.ingeneo.cinemas.entities.CinemaBranch;
import com.ingeneo.cinemas.entities.Room;
import com.ingeneo.cinemas.entities.Type;
import com.ingeneo.cinemas.interfaces.RoomService;
import com.ingeneo.cinemas.repositories.CinemaBranchRepository;
import com.ingeneo.cinemas.repositories.RoomRepository;
import com.ingeneo.cinemas.repositories.TypeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{
	
	private static final String TYPE_NOT_FOUND = "Tipo de sala/formato no encontrado";
	private static final String NOT_ROOM_CREATED = "La sala indicada no se encuentra creada";
	
	private final RoomRepository roomRepository;
	private final CinemaBranchRepository cinemaBranchRepository;
	private final TypeRepository typeRepository;

	@Override
	public void saveRoom(RoomRequestBody roomRequestBody) throws Exception {
		
		roomRepository.save(Room.builder()
				.type(getType(roomRequestBody.getType()))
				.rowsNumber(roomRequestBody.getRowsNumber())
				.maxChairsNumber(roomRequestBody.getMaxRowsNumber())
				.cinemaBranch(getCinemaBranch(roomRequestBody.getCinemaBranch()))
				.build());
		
	}

	private CinemaBranch getCinemaBranch(Long id) throws Exception {
		
		Optional<CinemaBranch> cinemaBranch = cinemaBranchRepository.findById(id);
		if(!cinemaBranch.isPresent()) {
			throw new Exception(String.format(NOT_ROOM_CREATED, id));
		}
		return cinemaBranch.get();
	}

	private Type getType(Long id) throws Exception {
		
		Optional<Type> type = typeRepository.findById(id);
		if(!type.isPresent()) {
			throw new Exception(String.format(TYPE_NOT_FOUND, id));
		}
		return type.get();
	}

}
