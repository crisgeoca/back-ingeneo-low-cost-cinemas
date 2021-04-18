package com.ingeneo.cinemas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.cinemas.entities.Manager;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, String>{

}
