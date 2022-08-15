package br.com.ada.moviesbattle.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.ada.moviesbattle.service.MovieServiceImpl;

@Component
@EnableAsync
public class LoadMovieTask {

	@Autowired
	MovieServiceImpl movieServiceImpl;
	
	private static final Logger logger = LoggerFactory.getLogger(LoadMovieTask.class);
	
	@Async
	@Scheduled(fixedDelay = 100000)
	public void loadMovies() throws Exception {
		
		logger.info("Starting scheduled task to load movies.");
		
		movieServiceImpl.loadMovies();
		
		logger.info("Finishing scheduled task to load movies.");
	}
	
}
