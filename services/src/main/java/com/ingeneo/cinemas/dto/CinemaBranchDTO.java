package com.ingeneo.cinemas.dto;

import java.util.List;
import java.util.Set;

import com.ingeneo.cinemas.entities.City;
import com.ingeneo.cinemas.entities.Manager;
import com.ingeneo.cinemas.entities.Movie;
import com.ingeneo.cinemas.entities.Room;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CinemaBranchDTO {
	
	private Long id;

	private String name;

	private String address;

	private City city;

	private Manager manager;

	private List<Room> room;

	private Set<Movie> movies;

}
