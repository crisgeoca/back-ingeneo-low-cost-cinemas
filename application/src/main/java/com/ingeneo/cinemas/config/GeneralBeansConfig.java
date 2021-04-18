package com.ingeneo.cinemas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ingeneo.cinemas.impl.CityImpl;
import com.ingeneo.cinemas.repositories.CityRepository;

@Configuration
public class GeneralBeansConfig {
	
	@Bean("cityImpl")
	public CityImpl createCityImpl(CityRepository cityRepository){
		return new CityImpl(cityRepository);
	}

}
