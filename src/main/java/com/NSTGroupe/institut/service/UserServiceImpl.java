package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.User;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(long id) throws ResourceNotFound {

        User user = userRepository.findById(id).orElseThrow (
                ()-> new ResourceNotFound("user not found for id: "+id)
        );
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll() ;
    }

    @Override
    public Map<String, Boolean> deleteUser(long id) {
        userRepository.deleteById(id);
        Map<String, Boolean> res= new HashMap<>();
        res.put("deleted_user", Boolean.TRUE);
        return res;
    }

    @Override
    public User updateUser(long id, User user) throws ResourceNotFound {
        User old = getUser(id);
        old.setFirstname(user.getFirstname());
        old.setLastname(user.getLastname());
        old.setEmail(user.getEmail());
        old.setPassword(user.getPassword());
        return userRepository.save(old);
    }

    @Override
    public List<User> searchByFirstname(String firstname) {
        return userRepository.findByFirstname(firstname);
    }

    @Override
    public List<User> searchByLastname(String lastname) {
        return userRepository.findByLastname(lastname);
    }

    @Override
    public List<User> searchByFirstnameOrLastname(String firstname, String lastname) {
        return userRepository.findByFirstnameOrLastname(firstname, lastname);
    }

    @Override
    public List<User> searchByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}