package challenge.repositories;

import challenge.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
