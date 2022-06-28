package springboot.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import springboot.models.Cinema;
import springboot.models.User;

@Mapper
public interface CinemaMapper {

	@Select("select * from cinema")
	List<Cinema> findAll();

	@Select("select * from cinema where cinema_id = #{id}")
	Cinema getCinema(int id);

	@Insert("insert into cinema(cinema_name,address) values(#{cinemaName},#{address})")
	//@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(Cinema cine);
	
	@Update("update cinema set cinema_name = #{cinemaName},address = #{address} where cinema_id = #{cinemaId}")
	int update(Cinema cine);
	
	@Delete("DELETE FROM cinema WHERE cinema_id = #{cinemaId}")
	int delete(int id);
}
