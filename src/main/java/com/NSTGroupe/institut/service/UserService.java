package com.NSTGroupe.institut.service;


import com.NSTGroupe.institut.entities.User;
import com.NSTGroupe.institut.exception.ResourceNotFound;

import java.util.List;
import java.util.Map;

public interface UserService {

    public User save(User user);
    public User getUser(long id) throws ResourceNotFound;
    public List<User> getAllUsers();

    public Map<String, Boolean> deleteUser (long id);
    public User updateUser (long id, User user) throws ResourceNotFound;
    public List<User> searchByFirstname (String firstname);
    public List<User> searchByLastname (String lastname);
    public List<User> searchByFirstnameOrLastname (String firstname, String lastname);
    public List<User> searchByEmail (String email);


}