package br.com.ada.moviesbattle.service;

import java.util.List;
import java.util.ListIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ada.moviesbattle.dto.MovieDto;
import br.com.ada.moviesbattle.model.Movie;
import br.com.ada.moviesbattle.repository.MovieRepository;

@Service
public class MovieServiceImpl {

	@Autowired
	OmdbServiceImpl omdbService;

	@Autowired
	MovieRepository movieRepository;

	private static final Logger logger = LoggerFactory.getLogger(OmdbServiceImpl.class);

	public void loadMovies() throws Exception {

		List<MovieDto> movies;

		movies = omdbService.searchMovies();
		ListIterator<MovieDto> it = movies.listIterator();
		while (it.hasNext()) {
			MovieDto movie = it.next();
			movie = omdbService.getMovieDetail(movie.getImdbID());
			movieRepository.save(movie.convert());
		}

		logger.info("movies quantity: " + movieRepository.count());
	}

	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	public List<Movie> findRandom(int numLimit) throws Exception {
		
		List<Movie> movies = movieRepository.findRandom(numLimit);
		
		if (movies == null || movies.size() != numLimit) {
			throw new Exception("Movies are missing!");
		}
		
		return movies;
	}

}
