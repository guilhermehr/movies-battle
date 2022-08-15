package br.com.ada.moviesbattle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ada.moviesbattle.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {
	
	@Query(nativeQuery=true, value="SELECT * FROM Movie ORDER BY RANDOM() LIMIT :limit")
	List<Movie> findRandom(int limit);

}
