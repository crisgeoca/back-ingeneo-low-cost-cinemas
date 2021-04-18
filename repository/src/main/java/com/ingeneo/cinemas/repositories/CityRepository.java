package com.ingeneo.cinemas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.cinemas.entities.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{

}
