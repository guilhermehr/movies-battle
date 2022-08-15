package br.com.ada.moviesbattle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ada.moviesbattle.dto.IRanking;
import br.com.ada.moviesbattle.model.Game;
import br.com.ada.moviesbattle.model.StatusGame;

public interface GameRepository extends JpaRepository<Game, Long> {

	
	public List<Game> findByUserIdAndStatus(Long userId, StatusGame status);
	
	@Query(nativeQuery = true, value = "SELECT g.user_id as userId, u.name as name, sum(g.correct_count) as points" 
			+ " FROM game as g INNER JOIN user as u ON g.user_id = u.id"
			+ " GROUP BY user_id ORDER BY points DESC")
	public List<IRanking> ranking();
	
}
