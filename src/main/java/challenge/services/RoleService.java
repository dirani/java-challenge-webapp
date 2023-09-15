package challenge.services;

import challenge.entities.Role;
import challenge.repositories.RoleRepository;
import org.springframework.stereotype.Service;

//defining the business logic
@Service
public class RoleService
{

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleByName(String admin) {

        return roleRepository.findByName(admin);
    }
}