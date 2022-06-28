package springboot.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import springboot.models.Movie;

@Mapper
public interface MovieMapper {

	@Select("select * from movie")
	List<Movie> findAll();

	@Select("select * from cinema where movie_id = #{id}")
	Movie getMovie(int id);

	@Insert("insert into movie(cinema_id,movie_name,movie_time) values(#{cinemaId},#{movieName},#{movieTime})")
	//@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(Movie movi);
	
	@Update("update movie set cinema_id = #{cinemaId},movie_name = #{movieName},movie_time = #{movieTime] where cinema_id = #{cinemaId}")
	int update(Movie movi);
	
	@Delete("DELETE FROM movie WHERE movie_id = #{movieId}")
	int delete(int id);
}
