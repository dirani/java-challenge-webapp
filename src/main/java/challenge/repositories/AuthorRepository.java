package challenge.repositories;

import challenge.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
