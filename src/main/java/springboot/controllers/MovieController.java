package springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import springboot.mappers.MovieMapper;
import springboot.models.Movie;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")
@RestController
public class MovieController {
    @Autowired
    private MovieMapper mapper;

    @GetMapping("")
    public ResponseEntity<List<Movie>> listAll() {
        List<Movie> listMovie = mapper.findAll();
        return ResponseEntity.ok(listMovie);
    }

    @GetMapping("/hello")
    public String sayHello() {
    	return "Heelo!";
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        Movie movi = mapper.getMovie(id);
        if(movi != null){
            return ResponseEntity.ok(movi);
        }else {
            return ResponseEntity.status(404).body("Not Found");
        }

    }

    @PostMapping("")
    public ResponseEntity<Integer> createUser(@RequestBody Movie movie){
        return ResponseEntity.ok(mapper.insert(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody Movie movie, @PathVariable Integer id){
    	Movie movi = mapper.getMovie(id);
        if(movi != null){
        	movi.setCinemaId(movie.getCinemaId());
        	movi.setMovieName(movie.getMovieName());
        	movi.setMovieTime(movie.getMovieTime());
            return ResponseEntity.ok(mapper.update(movi));
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
