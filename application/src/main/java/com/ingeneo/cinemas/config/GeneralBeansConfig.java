package com.ingeneo.cinemas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ingeneo.cinemas.impl.CinemaBranchServiceImpl;
import com.ingeneo.cinemas.impl.CityServiceImpl;
import com.ingeneo.cinemas.impl.ManagerServiceImpl;
import com.ingeneo.cinemas.repositories.CinemaBranchRepository;
import com.ingeneo.cinemas.repositories.CityRepository;
import com.ingeneo.cinemas.repositories.ManagerRepository;

@Configuration
public class GeneralBeansConfig {
	
	@Bean("cityServiceImpl")
	public CityServiceImpl createCityServiceImpl(CityRepository cityRepository){
		return new CityServiceImpl(cityRepository);
	}
	
	@Bean("managerServiceImpl")
	public ManagerServiceImpl createManagerServiceImpl(ManagerRepository managerRepository){
		return new ManagerServiceImpl(managerRepository);
	}
	
	@Bean("cinemaBranchServiceImpl")
	public CinemaBranchServiceImpl createManagerServiceImpl(CinemaBranchRepository cinemaBranchRepository, 
			ManagerRepository managerRepository, CityRepository cityRepository){
		return new CinemaBranchServiceImpl(cinemaBranchRepository, managerRepository, 
				cityRepository);
	}

}
