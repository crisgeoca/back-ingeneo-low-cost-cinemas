package com.ingeneo.cinemas.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.cinemas.entities.Users;
import com.ingeneo.cinemas.enums.UserRole;

@Repository
@Transactional(readOnly = true)
public interface LoginRepositiry extends CrudRepository<Users, String>{
	
	Optional<Users> findByEmail(String email);
	
	Optional<Users> findByIdentificationNumberAndUserRole(String id, UserRole role);
	
	@Transactional
    @Modifying
    @Query("UPDATE users u " +
            "SET u.enabled = TRUE WHERE u.email = ?1")
    int enableAppUser(String email);

}
