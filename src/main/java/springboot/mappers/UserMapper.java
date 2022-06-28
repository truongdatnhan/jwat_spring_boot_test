package springboot.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import springboot.models.User;

@Mapper
public interface UserMapper {
	List<User> userList();

    User userInfo(int userId);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int userId);
}
