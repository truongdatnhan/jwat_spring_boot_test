package springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import springboot.mappers.CinemaMapper;
import springboot.models.Cinema;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/cinemas")
@RestController
public class CinemaController {
    @Autowired
    private CinemaMapper mapper;

    @GetMapping("")
    public ResponseEntity<List<Cinema>> listAll() {
        List<Cinema> listCinema = mapper.findAll();
        return ResponseEntity.ok(listCinema);
    }

    @GetMapping("/hello")
    public String sayHello() {
    	return "Heelo!";
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        Cinema cine = mapper.getCinema(id);
        if(cine != null){
            return ResponseEntity.ok(cine);
        }else {
            return ResponseEntity.status(404).body("Not Found");
        }

    }

    @PostMapping("")
    public ResponseEntity<Integer> createUser(@RequestBody Cinema cinema){
        return ResponseEntity.ok(mapper.insert(cinema));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody Cinema cinema, @PathVariable Integer id){
        Cinema cine = mapper.getCinema(id);
        if(cine != null){
            cine.setCinemaName(cinema.getCinemaName());
            cine.setAddress(cinema.getAddress());
            return ResponseEntity.ok(mapper.update(cine));
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
