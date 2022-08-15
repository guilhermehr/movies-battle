package br.com.ada.moviesbattle.config.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

	private static final Logger logger = LoggerFactory.getLogger(ControllerAdvisor.class);
	
	@ExceptionHandler(value = {Exception.class})
	protected void handle(Exception e) {
		logger.error(e.getMessage());
	}
}
