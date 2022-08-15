package br.com.ada.moviesbattle.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Quiz {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne	
	private User user;
	
	@ManyToOne
	private Movie movieOption1;

	@ManyToOne
	private Movie movieOption2;
	
	@Enumerated(EnumType.STRING)
	@Builder.Default
	private StatusQuiz status = StatusQuiz.NOT_ANSWERED;
	
	@ManyToOne
	private Movie answer;
	
	public Quiz() {
		
	}
	
	public Quiz(Long id, User user, Movie movieOption1, Movie movieOption2, StatusQuiz status, Movie answer) {
		super();
		this.id = id;
		this.user = user;
		this.movieOption1 = movieOption1;
		this.movieOption2 = movieOption2;
		this.status = status;
		this.answer = answer;
	}
	
}
