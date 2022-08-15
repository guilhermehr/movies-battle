package br.com.ada.moviesbattle.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Movie {

	@Id
	private String imdbID;
	
	@NotNull
	private String title;
	private int year;
	private String poster;
	private float imdbRating;
	private int imdbVotes;
	
	public Movie() {
		super();
	}

	public Movie(String imdbID, @NotNull String title, int year, String poster, float imdbRating, int imdbVotes) {
		super();
		this.imdbID = imdbID;
		this.title = title;
		this.year = year;
		this.poster = poster;
		this.imdbRating = imdbRating;
		this.imdbVotes = imdbVotes;
	}
	
}
