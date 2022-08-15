package br.com.ada.moviesbattle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableScheduling;

import br.com.ada.moviesbattle.service.MovieServiceImpl;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
@EnableSwagger2
@EnableScheduling
public class MoviesBattleApplication {

	@Autowired
	MovieServiceImpl movieServiceImpl;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MoviesBattleApplication.class, args);
	}

}
