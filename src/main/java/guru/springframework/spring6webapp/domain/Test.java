package guru.springframework.spring6webapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; // Import the Table annotation

@Entity
@Table(name = "test_") // Specify the desired table name here
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String role;


    // Other fields, getters, setters, etc.
}
