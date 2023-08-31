package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
