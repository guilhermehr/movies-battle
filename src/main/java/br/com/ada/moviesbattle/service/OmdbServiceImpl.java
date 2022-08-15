package br.com.ada.moviesbattle.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.dhiraj072.randomwordgenerator.RandomWordGenerator;

import br.com.ada.moviesbattle.dto.MovieDto;
import br.com.ada.moviesbattle.dto.OmdbSearchDto;

@Service
public class OmdbServiceImpl {

	@Value("${omdb.api.key}")
	private String apiKey;
	
	@Value("${ombd.num.attempt}")
	private int numAttempts;

	private static final Logger logger = LoggerFactory.getLogger(OmdbServiceImpl.class);

	public List<MovieDto> searchMovies() throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		
		do {
			String randomWord = RandomWordGenerator.getRandomWord().split(" ")[0];
			String url = String.format("https://www.omdbapi.com/?apikey=%s&type=movie&s=%s", apiKey, randomWord);
			logger.info(url);
			ResponseEntity<OmdbSearchDto> response = restTemplate.getForEntity(url, OmdbSearchDto.class);
			if(response.getStatusCode() != HttpStatus.OK) {
				throw new Exception("Erro na chamada da omdbapi! Código: " + response.getStatusCode());
			}
			OmdbSearchDto result = response.getBody();
			if (result.getResponse()) {
				return Arrays.asList(result.getSearch());
			}
		} while (numAttempts-- > 0);
		
		return null;

	}

	public MovieDto getMovieDetail(String imdbID) throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		String url = String.format("https://www.omdbapi.com/?apikey=%s&i=%s", apiKey, imdbID);
		logger.info(url);
		ResponseEntity<MovieDto> response = restTemplate.getForEntity(url, MovieDto.class);
		if(response.getStatusCode() != HttpStatus.OK) {
			throw new Exception("Error calling omdbapi! Code: " + response.getStatusCode());
		}
		return response.getBody();
	}

}