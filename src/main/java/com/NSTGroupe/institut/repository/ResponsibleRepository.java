package com.NSTGroupe.institut.repository;

import com.NSTGroupe.institut.entities.Guardian;
import com.NSTGroupe.institut.entities.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsibleRepository extends JpaRepository<Responsible,Long> {
    public List<Responsible> findByCin (String cin);

}
