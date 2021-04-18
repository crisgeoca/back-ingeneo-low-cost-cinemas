package com.ingeneo.cinemas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.cinemas.entities.MovieGenre;

@Repository
public interface MovieGenreRepository extends CrudRepository<MovieGenre, Long>{

}
