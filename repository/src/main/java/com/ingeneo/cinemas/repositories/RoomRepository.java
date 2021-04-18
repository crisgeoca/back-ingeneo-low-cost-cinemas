package com.ingeneo.cinemas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.cinemas.entities.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{

}
