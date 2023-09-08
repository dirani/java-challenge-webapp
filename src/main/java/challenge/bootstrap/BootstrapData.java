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
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public BootstrapData(UserRepository userRepository, RoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }

    @Override
    public void run(String... args) throws Exception {

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
}










