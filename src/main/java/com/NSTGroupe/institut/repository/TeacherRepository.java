package com.NSTGroupe.institut.repository;

import com.NSTGroupe.institut.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {


    public List<Teacher> findByCin (String cin);

    public List<Teacher> findByDiploma(String diploma);

    public List<Teacher> findByStartDateOfWork(Date startDateOfWork);







}
