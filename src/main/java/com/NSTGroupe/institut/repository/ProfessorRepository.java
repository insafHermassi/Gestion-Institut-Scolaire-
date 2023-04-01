package com.NSTGroupe.institut.repository;

import com.NSTGroupe.institut.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {


    public List<Professor> findByFirstname(String firstname);

    public List<Professor> findByLastname(String lastname);

    public List<Professor> findByFirstnameOrLastname(String firstname, String lastname);

    public List<Professor> findByEmail(String email);
   public List<Professor> findByCin (String cin);


}
