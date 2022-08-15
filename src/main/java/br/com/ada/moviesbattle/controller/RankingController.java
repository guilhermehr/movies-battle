package br.com.ada.moviesbattle.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ada.moviesbattle.dto.IRanking;
import br.com.ada.moviesbattle.service.GameServiceImpl;
import br.com.ada.moviesbattle.service.OmdbServiceImpl;

@RestController
@RequestMapping("/ranking")
public class RankingController {

	@Autowired
	GameServiceImpl gameService;
	
	private static final Logger logger = LoggerFactory.getLogger(OmdbServiceImpl.class);
	
	@GetMapping
	public ResponseEntity<List<IRanking>> ranking() throws Exception {

		List<IRanking> rankingList = gameService.ranking();
		return new ResponseEntity<List<IRanking>>(rankingList, HttpStatus.OK);
	}
	
}
