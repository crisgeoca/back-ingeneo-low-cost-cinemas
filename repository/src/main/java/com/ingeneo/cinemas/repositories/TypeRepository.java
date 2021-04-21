package com.ingeneo.cinemas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.cinemas.entities.Type;

@Repository
public interface TypeRepository extends CrudRepository<Type, Long>{
	
	Type findByDescription(String description);
	
}
