package com.ingeneo.cinemas.interfaces;

import com.ingeneo.cinemas.bodies.RoomRequestBody;

public interface RoomService {
	
	void saveRoom(RoomRequestBody roomRequestBody) throws Exception;

}
