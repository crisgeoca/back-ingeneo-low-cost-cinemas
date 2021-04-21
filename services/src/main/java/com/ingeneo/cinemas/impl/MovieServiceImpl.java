package com.ingeneo.cinemas.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.google.common.collect.Sets;
import com.ingeneo.cinemas.bodies.MovieRequestBody;
import com.ingeneo.cinemas.entities.CinemaBranch;
import com.ingeneo.cinemas.entities.Movie;
import com.ingeneo.cinemas.entities.MovieGenre;
import com.ingeneo.cinemas.entities.Type;
import com.ingeneo.cinemas.interfaces.MovieService;
import com.ingeneo.cinemas.repositories.CinemaBranchRepository;
import com.ingeneo.cinemas.repositories.MovieGenreRepository;
import com.ingeneo.cinemas.repositories.MovieRepository;
import com.ingeneo.cinemas.repositories.TypeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

	private static final String NO_TYPE_FOUND = "El tipo %s indicado no se encuentra registrado";

	private final MovieRepository movieRepository;
	private final CinemaBranchRepository cinemaBranchRepository;
	private final TypeRepository typeRepository;
	private final MovieGenreRepository movieGenreRepository;

	@Override
	public void saveMovie(MovieRequestBody movieRequestBody) throws Exception {

		movieRepository.save(Movie.builder()
				.originalName(movieRequestBody.getOriginalName())
				.translatedName(movieRequestBody.getTranslatedName())
				.releaseDate(movieRequestBody.getReleaseDate())
				.moviePic(convertToBytes(movieRequestBody.getMoviePic()))
				.finalReleaseDate(movieRequestBody.getFinalReleaseDate())
				.movieGenre(getGenres(movieRequestBody.getMovieGenre()))
				.synopsis(movieRequestBody.getSynopsis())
				.movieFormat(getFormat(movieRequestBody.getMovieFormat()))
				.minutesDuration(movieRequestBody.getMinutesDuration())
				.cinemaBranches(getBranches(movieRequestBody.getCinemaBranches()))
				.build());

	}

	private Set<CinemaBranch> getBranches(Set<String> cinemaBranches) {

		return Sets.newHashSet(cinemaBranchRepository.findAllById((Iterable<Long>)
				cinemaBranches
				.stream()
				.map(branchId -> Long.parseLong(branchId))
				.collect(Collectors.toList())));
	}

	private Type getFormat(String movieFormat) throws Exception {

		return typeRepository.findById(Long.parseLong(movieFormat)).orElseThrow(
				() -> new Exception(String.format(NO_TYPE_FOUND, movieFormat)));
	}

	private List<MovieGenre> getGenres(List<String> movieGenre) {

		return StreamSupport
				.stream(movieGenreRepository.findAllById((Iterable<Long>)
						movieGenre
						.stream()
						.map(movieGenreId -> Long.parseLong(movieGenreId))
						.collect(Collectors.toList())).spliterator(), false)
				.collect(Collectors.toList());
	}

	private byte[] convertToBytes(String moviePic) throws IOException {

		File file = new File(moviePic);
		byte[] picInBytes = new byte[(int) file.length()];
		FileInputStream fileInputStream = null;
		fileInputStream = new FileInputStream(file);
		fileInputStream.read(picInBytes);
		fileInputStream.close();

		return picInBytes;
	}

}
