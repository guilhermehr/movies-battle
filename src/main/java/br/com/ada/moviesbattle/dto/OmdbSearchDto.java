package br.com.ada.moviesbattle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OmdbSearchDto {

	@JsonProperty("Search")
	private MovieDto[] search;
	
	private int totalResults;
	
	@JsonProperty("Response")
	private Boolean response;

}
