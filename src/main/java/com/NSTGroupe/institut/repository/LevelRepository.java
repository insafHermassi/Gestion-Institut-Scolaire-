package com.NSTGroupe.institut.repository;

import com.NSTGroupe.institut.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level,Long> {
    public List<Level> findByLibelle (String libelle);
    public  List<Level> findByOption (String option);
}
