package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Student;
import org.springframework.data.repository.CrudRepository;
//import com.javatpoint.model.Student;
public interface StudentRepository extends CrudRepository<Student, Integer>
{
}
