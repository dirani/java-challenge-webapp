package challenge.bootstrap;

import challenge.domain.*;
import challenge.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt, Spring Framework Guru.
 */
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");
        Author ericSaved = authorRepository.save(eric);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");
        Author rodSaved = authorRepository.save(rod);

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");
        Book dddSaved = bookRepository.save(ddd);

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");
        Publisher savedPublisher = publisherRepository.save(publisher);

        dddSaved.setPublisher(savedPublisher);
        noEJBSaved.setPublisher(savedPublisher);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        User user1 = new User();
        user1.setUsername("dirani@gmail.com");
        user1.setPassword("password");
        User user1Saved = userRepository.save(user1);
        userRepository.save(user1);

        User user2 = new User();
        user2.setUsername("tbomfim@aubay.pt");
        user2.setPassword("password");
        User user2Saved = userRepository.save(user2);
        userRepository.save(user1);

        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        Role adminRoleSaved = roleRepository.save(adminRole);
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setName("ADMIN");
        Role userRoleSaved = roleRepository.save(userRole);
        roleRepository.save(userRole);

        user1Saved.getRoles().add(adminRoleSaved);
        user1Saved.getRoles().add(userRoleSaved);

        user2Saved.getRoles().add(userRoleSaved);

        userRepository.save(user1Saved);
        userRepository.save(user2Saved);
        roleRepository.save(adminRoleSaved);
        roleRepository.save(userRoleSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());

        System.out.println("Publisher Count: " + publisherRepository.count());

        System.out.println("User Count: " + userRepository.count());
        System.out.println("Role Count: " + roleRepository.count());
    }
}










