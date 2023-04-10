/*package com.NSTGroupe.institut.repository;

import com.NSTGroupe.institut.entities.Student;
import com.NSTGroupe.institut.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstname(String firstname);

    public List<Student> findByLastname(String lastname);

    public List<Student> findByFirstnameOrLastname(String firstname, String lastname);

    public List<Student> findByEmail(String email);

    public List<Student> findByNationality(String nationality);

    public List<Student> findByGender(String gender);
}

 */