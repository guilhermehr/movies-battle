package br.com.ada.moviesbattle.dto;

import org.apache.commons.lang3.math.NumberUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ada.moviesbattle.model.Movie;
import lombok.Data;

@Data
@JsonFormat
public class MovieDto {

	@JsonProperty("Title")
	private String title;

	@JsonProperty("Year")
	private String year;

	@JsonProperty("imdbID")
	private String imdbID;

	@JsonProperty("Poster")
	private String poster;

	@JsonProperty("imdbRating")
	private String imdbRating;

	@JsonProperty("imdbVotes")
	private String imdbVotes;

	public Movie convert() {
		
		float rating = NumberUtils.isCreatable(this.imdbRating) ? Float.valueOf(this.imdbRating) : 0f;
		int votes = NumberUtils.isCreatable(this.imdbVotes) ? Integer.valueOf(this.imdbVotes.replaceAll(",", "")) : 0;
		
		return Movie.builder()
				.imdbID(this.imdbID)
				.title(this.title)
				.year(Integer.valueOf(this.year))
				.imdbRating(rating)
				.imdbVotes(votes)
				.poster(this.poster)
				.build();
	}

}
