package challenge.domain;

import jakarta.persistence.*;
//        Create an endpoint to consume an API from TBMD to retrieve all the movies [(https://imdb-api.com/) ](https://developer.themoviedb.org/)and populate your database (you can use WebClient or Feign to consume the API). This API could be called just by the ADMIN user, see @Secured and Roles in Spring Security.
//        Create an endpoint to list all the movies.
//        Create an endpoint to include a movie to the user (favorite list)
//        Create an endpoint to exclude the movie from the favorite list
//        Each time the user includes the movie in the favorite list add one "star" to the movie
//        Create an endpoint to list the top 10 movies, the movies with more stars.
//        Create an endpoint to list the favorite movies per user.
//        Don't forget to include Swagger/OpenAPI, and the test.
/*
    user -> favorite list (movie) set


 */

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int releaseYear;
    private String genre;
    private double rating;

    public Movie() {
    }

    public Movie(Long id, String title, int releaseYear, String genre, double rating) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
    }

    // Getter and setter methods for id, title, releaseYear, genre, and rating
    // ...

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}

