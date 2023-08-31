package challenge.services;

import challenge.domain.Book;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface BookService {

    Iterable<Book> findAll();

}
