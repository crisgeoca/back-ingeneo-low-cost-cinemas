package com.ingeneo.cinemas.impl;

import com.ingeneo.cinemas.bodies.MovieScheduleRequestBody;
import com.ingeneo.cinemas.entities.Movie;
import com.ingeneo.cinemas.entities.MovieSchedule;
import com.ingeneo.cinemas.entities.Room;
import com.ingeneo.cinemas.interfaces.MovieScheduleService;
import com.ingeneo.cinemas.repositories.MovieRepository;
import com.ingeneo.cinemas.repositories.MovieScheduleRepository;
import com.ingeneo.cinemas.repositories.RoomRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovieScheduleServiceImpl implements MovieScheduleService{
			
	private static final String NOT_ROOM_FOUND = "No existe la sala %s";
	private static final String NOT_MOVIE_FOUND = "No existe la pelicula indicada %s";
	
	private final MovieScheduleRepository movieScheduleRepository;
	private final RoomRepository roomRepository;
	private final MovieRepository movieRepository;

	@Override
	public void scheduleMovie(MovieScheduleRequestBody movieScheduleRequestBody) throws NumberFormatException, Exception {
				
		movieScheduleRepository.save(MovieSchedule.builder()
				.room(getRoom(movieScheduleRequestBody.getRoom()))
				.movie(getMovie(movieScheduleRequestBody.getMovie()))
				.scheduledDate(movieScheduleRequestBody.getScheduledDate())
				.build());
		
	}

	private Movie getMovie(String movie) throws NumberFormatException, Exception {		
		return movieRepository.findById(Long.parseLong(movie))
				.orElseThrow(() -> new Exception(String.format(NOT_MOVIE_FOUND, movie)));
	}

	private Room getRoom(String room) throws NumberFormatException, Exception {
		return roomRepository.findById(Long.parseLong(room))
				.orElseThrow(() -> new Exception(String.format(NOT_ROOM_FOUND, room)));
	}

}
