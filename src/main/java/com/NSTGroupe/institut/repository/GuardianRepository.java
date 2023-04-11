package com.NSTGroupe.institut.repository;

import com.NSTGroupe.institut.entities.Administrator;
import com.NSTGroupe.institut.entities.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GuardianRepository extends JpaRepository<Guardian,Long> {
    public List<Guardian> findByCin (String cin);

    public List<Guardian> findByStartDateOfWork(Date startDateOfWork);
}
