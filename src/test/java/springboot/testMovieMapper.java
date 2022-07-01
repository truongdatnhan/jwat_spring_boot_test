package springboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import springboot.models.Movie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;

import springboot.mappers.MovieMapper;

@DataJpaTest
@Rollback(true)

public class testMovieMapper {
    @Autowired
    private MovieMapper mapper;

    @Test
    public void testListAllMovie(){
        List<Movie> listMovie = mapper.findAll();

        assertThat(listMovie).hasSizeGreaterThan(0);
    }
    @Test
    public void testgetMovie(){
        int id=1;
        Movie movi = mapper.getMovie(id);

        assertThat(movi.getMovieName()).isEqualTo("Minion");
        
    }
    @Test
    public void testInsertMovie(){
        Movie movie = new Movie();
        movie.setMovieName("Iron man");
        movie.setCinemaId(1);
  
        assertThat(movie.getMovieName()).isEqualTo("Iron man");
    }
    @Test
    public void testUpdateMovie(){
        Movie movie = new Movie();
        movie.setMovieName("Iron man");
        movie.setCinemaId(1);
  
        assertThat(movie.getMovieName()).isEqualTo("Iron man");
    }
    @Test
    public void testDeleteMovie(){
        int id = 1;
        mapper.delete(id);

        Movie movie = mapper.getMovie(id);
        assertThat(movie).isNull();
    }
}
