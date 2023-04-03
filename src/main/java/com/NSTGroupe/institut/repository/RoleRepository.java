package com.NSTGroupe.institut.repository;

import com.NSTGroupe.institut.entities.ERole;
import com.NSTGroupe.institut.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
