package com.NSTGroupe.institut.controller;
import com.NSTGroupe.institut.entities.User;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController extends BasicController{
    @Autowired
    UserService userService;

    @GetMapping(value = "welcome")
    public String welcome () {
        return ("Welcome, I'am a robot. I will help you to manage Users. ");
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/AllUsers")
    public List<User> getUsers(){
        return  userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") long id)throws ResourceNotFound {
        return userService.getUser(id);
    }

    @GetMapping(value = "/get")
    public User getUserByParam(@RequestParam("id") long id) throws ResourceNotFound {
        return userService.getUser(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteUser(@RequestParam("id") long id){
        return  userService.deleteUser(id);
    }

    @PutMapping
    public User updateUser(@RequestParam("id") long id, @Valid @RequestBody User user) throws ResourceNotFound {
        return userService.updateUser(id, user);
    }

    @GetMapping(value = "/searchByUser_Firstname")
    public List<User> getByFirstname(@RequestParam("User_firstname") String firstname){
        return userService.searchByFirstname(firstname);
    }

    @GetMapping(value = "/searchByUser_Lastname")
    public List<User> getByLastname(@RequestParam("User_lastname") String lastname){
        return userService.searchByLastname(lastname);
    }

    @GetMapping(value = "/searchByUser_Firstname_Or_Lastname")
    public List<User> getByFirstnameOrLastname(@RequestParam("User_name") String firstname, String lastname){
        return userService.searchByFirstnameOrLastname(firstname, lastname);
    }

    @GetMapping(value = "/searchByEmail")
    public List<User> getByEmail(@RequestParam("User_email") String email){
        return userService.searchByEmail(email);
    }

}