package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.domain.User;
import guru.springframework.spring6webapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//defining the business logic
@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;
    //getting all user records
    public List<User> getAllUser()
    {
        //userRepository.findAll().stream().toList(); //toList java17
        return userRepository.findAll();
    }
    //getting a specific record
    public User getUserById(Long id)
    {
        return userRepository.findById(id).orElseThrow();
    }
    public void saveOrUpdate(User user)
    {
        userRepository.save(user);
    }
    //deleting a specific record
    public void delete(Long id)
    {
        userRepository.deleteById(id);
    }
}