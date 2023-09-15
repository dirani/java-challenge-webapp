package challenge.services;

import challenge.model.MovieDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {

    private Map<UUID, MovieDTO> movieMap;

    public MovieServiceImpl() {
         MovieDTO movie1 = MovieDTO.builder()
                .id(UUID.randomUUID())
                .title("CMovie 1")
                .build();

        MovieDTO movie2 = MovieDTO.builder()
                .id(UUID.randomUUID())
                .title("CMovie 2")
                .build();

        MovieDTO movie3 = MovieDTO.builder()
                .id(UUID.randomUUID())
                .title("CMovie 3")
                .build();

        movieMap = new HashMap<>();
        movieMap.put(movie1.getId(), movie1);
        movieMap.put(movie2.getId(), movie2);
        movieMap.put(movie3.getId(), movie3);
    }

    @Override
    public void patchMovieById(UUID movieId, MovieDTO movie) {
        MovieDTO existing = movieMap.get(movieId);

        if (StringUtils.hasText(movie.getTitle())) {
            existing.setTitle(movie.getTitle());
        }
    }

    @Override
    public void deleteMovieById(UUID movieId) {
        movieMap.remove(movieId);
    }

    @Override
    public void updateMovieById(UUID movieId, MovieDTO movie) {
        MovieDTO existing = movieMap.get(movieId);
        existing.setTitle(movie.getTitle());
    }

    @Override
    public MovieDTO saveNewMovie(MovieDTO movie) {

        MovieDTO savedMovie = MovieDTO.builder()
                .id(UUID.randomUUID())
                .title(movie.getTitle())
                .build();

        movieMap.put(savedMovie.getId(), savedMovie);

        return savedMovie;
    }

    @Override
    public Optional<MovieDTO> getMovieById(UUID uuid) {
        return Optional.of(movieMap.get(uuid));
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return new ArrayList<>(movieMap.values());
    }
}




