package com.ingeneo.cinemas.interfaces;

import com.ingeneo.cinemas.bodies.MovieScheduleRequestBody;

public interface MovieScheduleService {
	
	void scheduleMovie(MovieScheduleRequestBody movieScheduleRequestBody) throws NumberFormatException, Exception;

}
