package com.ingeneo.cinemas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.cinemas.entities.MovieSchedule;

@Repository
public interface MovieScheduleRepository extends CrudRepository<MovieSchedule, Long>{

}
