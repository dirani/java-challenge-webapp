package challenge.controllers;

import challenge.domain.Role;
import challenge.domain.User;
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
    //autowired the StudentService class
    @Autowired
    UserService userService;
    //creating a get mapping that retrieves all the students detail from the database
    @Autowired
    RoleService roleService;
    @GetMapping
    private List<User> getAllStudent()
    {
        return userService.getAllUser();
    }
    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/{id}")
    private User getUser(@PathVariable("id") Long id)
    {
        return userService.getUserById(id);
    }
    //creating a delete mapping that deletes a specific student
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

}
