package com.NSTGroupe.institut.repository;

import com.NSTGroupe.institut.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator,Long> {

    public List<Administrator>  findByCin (String cin);

      public List<Administrator> findByStartDateOfWork(Date startDateOfWork);

}
