package challenge.controllers;

import challenge.domain.User;
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
}
