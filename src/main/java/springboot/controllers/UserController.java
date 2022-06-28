package springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import springboot.mappers.UserMapper;
import springboot.models.User;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/users")
@RestController
public class UserController {
    @Autowired
    private UserMapper mapper;

    @GetMapping("")
    public ResponseEntity<List<User>> listAll() {
        List<User> listUsers = mapper.userList();
        return ResponseEntity.ok(listUsers);
    }

    @GetMapping("/hello")
    public String sayHello() {
    	return "Heelo!";
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        User user = mapper.userInfo(id);
        if(user != null){
            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.status(404).body("Not Found");
        }

    }

    @PostMapping("")
    public ResponseEntity<Integer> createUser(@RequestBody User user){
        return ResponseEntity.ok(mapper.addUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Integer id){
        User userInfo = mapper.userInfo(id);
        if(userInfo != null){
        	userInfo.setUserName(user.getUserName());
        	userInfo.setPassword(user.getPassword());
        	userInfo.setEmail(user.getEmail());
        	userInfo.setAddress(user.getAddress());
            userInfo.setPhone(user.getPhone());
            return ResponseEntity.ok(mapper.updateUser(userInfo));
        }else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
//        Optional<User> user = repo.findById(id);
//        if(user.isPresent()){
//            repo.delete(user.get());
//            return ResponseEntity.ok("Deleted Successfully");
//        }else {
//            return ResponseEntity.status(404).body("Not Found");
//        }
//    }

}
