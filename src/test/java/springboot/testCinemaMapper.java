package springboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import springboot.models.Cinema;

import static org.assertj.core.api.Assertions.assertThat;
import springboot.mappers.CinemaMapper;

@DataJpaTest
@Rollback(true)

public class testCinemaMapper {
    @Autowired
    private CinemaMapper mapper;

    @Test
    public void testListAllCinema(){
        List<Cinema> listCinema = mapper.findAll();

        assertThat(listCinema).hasSizeGreaterThan(0);
    }
    @Test
    public void testgetCinema(){
        int id=1;
        Cinema movi = mapper.getCinema(id);

        assertThat(movi.getCinemaName()).isEqualTo("CGV");
        
    }
    @Test
    public void testInsertCinema(){
        Cinema Cinema = new Cinema();
        Cinema.setCinemaName("Lotte");
        Cinema.setAddress("tphcm");
  
        assertThat(Cinema.getCinemaName()).isEqualTo("Lotte");
    }
    @Test
    public void testUpdateCinema(){
        Cinema Cinema = new Cinema();
        Cinema.setCinemaName("Lotte");
        Cinema.setAddress("tphcm");
  
        assertThat(Cinema.getCinemaName()).isEqualTo("Lotte");
    }
    @Test
    public void testDeleteCinema(){
        int id = 1;
        mapper.delete(id);

        Cinema Cinema = mapper.getCinema(id);
        assertThat(Cinema).isNull();
    }
}
