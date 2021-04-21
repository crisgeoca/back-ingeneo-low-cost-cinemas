package com.ingeneo.cinemas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.cinemas.entities.Room;
import com.ingeneo.cinemas.entities.Type;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
	
	List<Room> findAllByType(Type type);

}
