package com.NSTGroupe.institut.repository;

import com.NSTGroupe.institut.entities.Professor;
import com.NSTGroupe.institut.entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorRepository extends JpaRepository<Sector,Long> {

    public List<Sector> findByName_sector(String name_sector);

}
