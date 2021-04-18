package com.ingeneo.cinemas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.cinemas.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, String>{

}
