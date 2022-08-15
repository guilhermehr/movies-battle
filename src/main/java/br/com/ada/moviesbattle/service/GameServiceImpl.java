package br.com.ada.moviesbattle.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.ada.moviesbattle.dto.IRanking;
import br.com.ada.moviesbattle.model.Game;
import br.com.ada.moviesbattle.model.Movie;
import br.com.ada.moviesbattle.model.StatusGame;
import br.com.ada.moviesbattle.model.User;
import br.com.ada.moviesbattle.repository.GameRepository;
import br.com.ada.moviesbattle.repository.UserRepository;

@Service
public class GameServiceImpl {

	@Autowired
	GameRepository gameRepository;

	@Autowired
	MovieServiceImpl movieService;

	@Autowired
	UserRepository userRepository;
	
	@Value("${game.num.options}")
	private int numOptions;
	
	@Value("${game.wrong.limit}")	
	private int wrongLimit;

	private static final Logger logger = LoggerFactory.getLogger(OmdbServiceImpl.class);

	public List<Movie> newQuiz(User user) throws Exception {

		List<Movie> movies = new ArrayList<Movie>();

		List<Game> gameList = gameRepository.findByUserIdAndStatus(user.getId(), StatusGame.PENDING);

		if (gameList != null && !gameList.isEmpty()) {
			movies.add(gameList.get(0).getMovieOption1());
			movies.add(gameList.get(0).getMovieOption2());
			return movies;
		}

		movies = movieService.findRandom(numOptions);

		Game newGame = Game.builder()
				.movieOption1(movies.get(0))
				.movieOption2(movies.get(1))
				.user(user)
				.build();
		
		gameRepository.save(newGame);

		return movies;
	}

	public boolean checkAnswer(User user, String imdbID) throws Exception {
		
		List<Game> gameList = gameRepository.findByUserIdAndStatus(user.getId(), StatusGame.PENDING);

		if (gameList == null && gameList.isEmpty()) {
			throw new Exception("Start a new game! id: " + user.getId());
		}
		
		Game game = gameList.get(0);
		
		Boolean result = compareQuizOptions(game, imdbID);
	
		List<Movie> movies = movieService.findRandom(numOptions);
		
		game.setMovieOption1(movies.get(0));
		game.setMovieOption2(movies.get(1));
		
		gameRepository.save(game);
		
		return result;
	}
	
	
	public List<IRanking> ranking() {
		
		return gameRepository.ranking();
		
	}
	

	private boolean compareQuizOptions(Game game, String imdbID) {
	
		Movie movie1 = game.getMovieOption1();
		Movie movie2 = game.getMovieOption2();
		
		float points1 = movie1.getImdbRating() * movie1.getImdbVotes();
		float points2 = movie2.getImdbRating() * movie2.getImdbVotes();
		
		int correctCount = game.getCorrectCount();
		int wrongCount = game.getWrongCount();
		
		if(movie1.getImdbID().equals(imdbID)) {
			if(points1 >= points2) {
				correctCount++;
			}
		} else {
			if(points1 <= points2) {
				correctCount++;
			}
		}
		
		if(correctCount == game.getCorrectCount()) {
			wrongCount++;
			if(wrongCount >= this.wrongLimit) {
				game.setStatus(StatusGame.WRONG_LIMIT);
			}
			return false;
		}
		
		game.setCorrectCount(correctCount);
		
		return true;
	}
	
}
