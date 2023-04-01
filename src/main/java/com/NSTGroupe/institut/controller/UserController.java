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

    @GetMapping(value = "welcome_user")
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

    @GetMapping(value = "/searchByUsername")
    public List<User> getByUsername(@RequestParam("username") String username){
        return userService.searchByUsername(username);
    }



    @GetMapping(value = "/searchByEmail")
    public List<User> getByEmail(@RequestParam("User_email") String email){
        return userService.searchByEmail(email);
    }

}