package springboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import springboot.models.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import springboot.mappers.UserMapper;

@DataJpaTest
@Rollback(true)
public class testUserMapper {
    @Autowired
    private UserMapper mapper;

    @Test
    public void testUserList() {
        List<User> listUsers = mapper.userList();

        assertThat(listUsers).hasSizeGreaterThan(0);
    }

    @Test
    public void testUserInfo() {
        int id = 1;
        User user = mapper.userInfo(id);

        assertThat(user.getUserName()).isEqualTo("uyn");
    }
    @Test
    public void testaddUser(){
        
        User user = new User();
        user.setUserName("nhan");
        user.setPassword("nhan");
        user.setEmail("nhan@gmail.com");
        user.setPhone("258741963");
        user.setAddress("tphcm");
        mapper.addUser(user);
        
        assertThat(user.getUserName()).isEqualTo("nhan");
    }
    @Test
    public void testupdateUser(){
        User user=new User();
        user.setUserName("nhan");
        user.setPassword("nhan");
        user.setEmail("nhan@gmail.com");
        user.setPhone("258741963");
        user.setAddress("tphcm");

        mapper.addUser(user);
        
        assertThat(user.getUserName()).isEqualTo("nhan");
    }
    @Test
    public void testdeleteUser(){
        int id = 1;
        mapper.deleteUser(id);

        User user = mapper.userInfo(id);
        assertThat(user).isNull();
    }
}
