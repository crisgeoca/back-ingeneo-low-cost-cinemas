package com.ingeneo.cinemas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.cinemas.entities.MovieBooking;

@Repository
public interface MovieBookingRepository extends CrudRepository<MovieBooking, Long>{

}
