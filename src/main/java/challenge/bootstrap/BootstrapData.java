package challenge.bootstrap;

import challenge.entities.*;
import challenge.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
        loadMovieData();



    }

    private void loadUserData() {

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
        userRole.setName("USER");
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
        System.out.println("User Count: " + userRepository.count());
        System.out.println("Role Count: " + roleRepository.count());
    }

    private void loadMovieData() {

        if (movieRepository.count() == 0) {
            Movie movie1 = Movie.builder()
                    .id(UUID.randomUUID())
                    .title("BMovie 1")
                    .build();

            Movie movie2 = Movie.builder()
                    .id(UUID.randomUUID())
                    .title("BMovie 2")
                    .build();

            Movie movie3 = Movie.builder()
                    .id(UUID.randomUUID())
                    .title("BMovie 3")
                    .build();

            movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3));
        }

    }

}










