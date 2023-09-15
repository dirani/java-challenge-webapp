package challenge.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    public Movie() {
    }

    // Getter and setter methods for id, title, releaseYear, genre, and rating
    // ...

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title +
                '}';
    }
}
