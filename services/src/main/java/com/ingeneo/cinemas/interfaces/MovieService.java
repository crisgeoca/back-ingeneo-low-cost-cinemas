package com.ingeneo.cinemas.interfaces;

import com.ingeneo.cinemas.bodies.MovieRequestBody;

public interface MovieService {
	
	void saveMovie(MovieRequestBody movieRequestBody) throws Exception;

}
