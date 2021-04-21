package com.ingeneo.cinemas.impl;

import com.ingeneo.cinemas.bodies.MovieGenreRequestBody;
import com.ingeneo.cinemas.entities.MovieGenre;
import com.ingeneo.cinemas.interfaces.MovieGenreService;
import com.ingeneo.cinemas.repositories.MovieGenreRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovieGenreServiceImpl implements MovieGenreService{
	
	private final MovieGenreRepository movieGenreRepository;

	@Override
	public void saveMovieGenre(MovieGenreRequestBody movieGenreRequestBody) {
		movieGenreRepository.save(MovieGenre.builder()
				.description(movieGenreRequestBody.getDescription())
				.build());
		
	}

}
