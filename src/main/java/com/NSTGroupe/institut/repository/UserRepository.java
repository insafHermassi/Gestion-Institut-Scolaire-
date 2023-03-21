package com.NSTGroupe.institut.repository;

import com.NSTGroupe.institut.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByFirstname(String firstname);

    public List<User> findByLastname(String lastname);

    public List<User> findByFirstnameOrLastname(String firstname, String lastname);

    public List<User> findByEmail(String email);

}