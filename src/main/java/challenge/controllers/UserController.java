package challenge.controllers;

import challenge.entities.Role;
import challenge.entities.User;
import challenge.services.RoleService;
import challenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//creating RestController
@RestController
@RequestMapping("/users")
public class UserController
{
    //autowired the UserService class
    @Autowired
    UserService userService;
    //autowired the RoleService class
    @Autowired
    RoleService roleService;
    //creating a get mapping that retrieves all the user detail from the database
    @GetMapping
    private List<User> getAllUsers()
    {
        return userService.getAllUser();
    }
    //creating a get mapping that retrieves the detail of a specific user
    @GetMapping("/{id}")
    private User getUser(@PathVariable("id") Long id)
    {
        return userService.getUserById(id);
    }
    //creating a delete mapping that deletes a specific user
    @DeleteMapping("/{id}")
    private void deleteUser(@PathVariable("id") Long id)
    {
        userService.delete(id);
    }
    //creating post mapping that post the student detail in the database
    @PostMapping
    private Long saveUser(@RequestBody User user)
    {
        userService.saveOrUpdate(user);
        return user.getId();
    }
    @PutMapping("/{id}")
    private void addRoleAdmin(@PathVariable("id") Long id)
    {
        User user = userService.getUserById(id);
        Role admin = roleService.getRoleByName("ADMIN");
        user.addRole(admin);
        userService.saveOrUpdate(user);
    }
// poderia estar em user service
    // onde já tem os métodos
}
