package com.ingeneo.cinemas.interfaces;

import java.util.List;

import com.ingeneo.cinemas.bodies.RoomRequestBody;
import com.ingeneo.cinemas.dto.RoomsByTypeDTO;

public interface RoomService {
	
	void saveRoom(RoomRequestBody roomRequestBody) throws Exception;
	
	List<RoomsByTypeDTO> findAllByType(String type) throws NumberFormatException, Exception;

}
