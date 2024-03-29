package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.User;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        return userRepository.findAll() ;
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
        old.setUsername(user.getUsername());
        old.setPassword(user.getPassword());
        return userRepository.save(old);
    }

    @Override
    public Optional<User> searchByUsername(String username) {
        return userRepository.findByUsername(username);
    }



}