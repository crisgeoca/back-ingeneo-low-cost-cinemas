package com.ingeneo.cinemas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.cinemas.entities.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{

}
