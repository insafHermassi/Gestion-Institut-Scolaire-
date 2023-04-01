package com.NSTGroupe.institut.repository;

import com.NSTGroupe.institut.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module,Long> {

    public List<Module> findByName_module(String name_module);
}
