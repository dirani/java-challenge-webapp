package challenge.services;

import challenge.model.MovieDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieService {
    Optional<MovieDTO> getMovieById(UUID id);

    List<MovieDTO> getAllMovies();

    MovieDTO saveNewMovie(MovieDTO movie);

    void updateMovieById(UUID movieId, MovieDTO movie);

    void deleteMovieById(UUID movieId);

    void patchMovieById(UUID movieId, MovieDTO movie);










}
