package com.ingeneo.cinemas.impl;

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
	
	private static final String TYPE_NOT_FOUND = "Tipo de sala/formato %s no encontrado";
	private static final String NOT_ROOM_CREATED = "La sala %s indicada no se encuentra creada";
	
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
		
		return cinemaBranchRepository.findById(id).orElseThrow(
				() -> new Exception(String.format(NOT_ROOM_CREATED, id)));
	}

	private Type getType(Long id) throws Exception {
		
		return typeRepository.findById(id).orElseThrow(
				() -> new Exception(String.format(TYPE_NOT_FOUND, id)));
	}

}
