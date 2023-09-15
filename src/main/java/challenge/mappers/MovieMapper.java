package challenge.mappers;

import challenge.entities.Movie;
import challenge.model.MovieDTO;
import org.mapstruct.Mapper;

@Mapper
public interface MovieMapper {

    Movie movieDtoToMovie(MovieDTO dto);

    MovieDTO movieToMovieDto(Movie movie);

}