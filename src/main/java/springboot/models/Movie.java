package springboot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	private int movieId;
	private int cinemaId;
    private String movieName;
    //@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime movieTime;
}
