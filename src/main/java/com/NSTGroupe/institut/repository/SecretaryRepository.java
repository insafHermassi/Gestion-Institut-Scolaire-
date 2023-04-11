package com.NSTGroupe.institut.repository;

import com.NSTGroupe.institut.entities.Guardian;
import com.NSTGroupe.institut.entities.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SecretaryRepository extends JpaRepository<Secretary,Long> {
    public List<Secretary> findByCin (String cin);

    public List<Secretary> findByStartDateOfWork(Date startDateOfWork);
}
