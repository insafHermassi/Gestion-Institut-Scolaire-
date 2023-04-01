package com.NSTGroupe.institut.repository;

import com.NSTGroupe.institut.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality,Long> {
    public List<Speciality> findByName_speciality(String name_speciality);
    public  List<Speciality> findByLibellle(String libelle);
}
