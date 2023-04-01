package com.NSTGroupe.institut.repository;

import com.NSTGroupe.institut.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByUsername(String username);

    public List<User> findByEmail(String email);

}