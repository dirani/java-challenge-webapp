package challenge.repositories;

import challenge.domain.Student;
import org.springframework.data.repository.CrudRepository;
//import com.javatpoint.model.Student;
public interface StudentRepository extends CrudRepository<Student, Integer>
{
}
