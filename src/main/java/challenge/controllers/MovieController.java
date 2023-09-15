package challenge.controllers;

import challenge.model.MovieDTO;
import challenge.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class MovieController {

    public static final String MOVIE_PATH = "/api/v1/movie";
    public static final String MOVIE_PATH_ID = MOVIE_PATH + "/{customerId}";
    private final MovieService movieService;

    @PatchMapping(MOVIE_PATH_ID)
    public ResponseEntity patchMovieById(@PathVariable("movieId") UUID movieId,
                                         @RequestBody MovieDTO movie){

        movieService.patchMovieById(movieId, movie);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(MOVIE_PATH_ID)
    public ResponseEntity deleteMovieById(@PathVariable("movieId") UUID movieId){

        movieService.deleteMovieById(movieId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(MOVIE_PATH_ID)
    public ResponseEntity updateMovieByID(@PathVariable("movieId") UUID movieId,
                                          @RequestBody MovieDTO movie){

        movieService.updateMovieById(movieId, movie);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(MOVIE_PATH)
    public ResponseEntity handlePost(@RequestBody MovieDTO movie){
        MovieDTO savedMovie = movieService.saveNewMovie(movie);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", MOVIE_PATH + "/" + savedMovie.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping(MOVIE_PATH)
    public List<MovieDTO> listAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping(value = MOVIE_PATH_ID)
    public Object getMovieById(@PathVariable("movieId") UUID id){
        return movieService.getMovieById(id).orElseThrow(NotFoundException::new);
    }


}
