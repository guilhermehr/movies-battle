package br.com.ada.moviesbattle.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ada.moviesbattle.model.Movie;
import br.com.ada.moviesbattle.model.User;
import br.com.ada.moviesbattle.service.GameServiceImpl;
import br.com.ada.moviesbattle.service.OmdbServiceImpl;

@RestController
@RequestMapping("/game")
public class GameController {

	@Autowired
	GameServiceImpl gameService;
	
	private static final Logger logger = LoggerFactory.getLogger(OmdbServiceImpl.class);
	
	@GetMapping("/quiz")
	public ResponseEntity<List<Movie>> newQuiz() throws Exception {

		List<Movie> movies = gameService.newQuiz(getUserAuthenticated());
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	
	@GetMapping("/quiz/{imdbID}")
	public  ResponseEntity<Boolean> answerQuiz(@PathVariable String imdbID) throws Exception {
		
		logger.info(imdbID);
		
		Boolean result = gameService.checkAnswer(getUserAuthenticated(), imdbID);
		
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	
	private User getUserAuthenticated() {
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		return (User) auth.getPrincipal();
	}
	
}
