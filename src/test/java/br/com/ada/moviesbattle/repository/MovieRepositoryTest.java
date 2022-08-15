package br.com.ada.moviesbattle.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ada.moviesbattle.model.Movie;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class MovieRepositoryTest {

	@Autowired
	private MovieRepository repository;
	
	@Test
	public void shouldReturnTwoMovies() {
		int limit = 2;		
		List<Movie> movies = repository.findRandom(limit);
		Assert.assertNotNull(movies);
		Assert.assertEquals(movies.size(), limit);
	}
	
}
