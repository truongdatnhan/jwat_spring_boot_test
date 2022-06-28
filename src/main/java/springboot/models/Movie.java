package springboot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	private int movieId;
	private int cinemaId;
    private String movieName;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date movieTime;
}
