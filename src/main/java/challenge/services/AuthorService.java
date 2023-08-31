package challenge.services;

import challenge.domain.Author;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface AuthorService {

    Iterable<Author> findAll();

}
