package com.ingeneo.cinemas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.cinemas.entities.CinemaBranch;

@Repository
public interface CinemaBranchRepository extends CrudRepository<CinemaBranch, Long>{

}
