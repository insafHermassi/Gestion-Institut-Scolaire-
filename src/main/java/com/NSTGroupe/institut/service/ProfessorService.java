package com.NSTGroupe.institut.service;


import com.NSTGroupe.institut.entities.Professor;
import com.NSTGroupe.institut.exception.ResourceNotFound;

import java.util.List;
import java.util.Map;

public interface ProfessorService {

    public Professor save(Professor professor);
    public  Professor getProfessor(long id) throws ResourceNotFound;
    public List<Professor> getAllProfessors();
    public Map<String,Boolean> deleteProfessor(long id);
    public  Professor updateProfessor(long id,Professor professor) throws  ResourceNotFound;
    public List<Professor> searchByFirstname(String firstname);

    public List<Professor> searchByLastname(String lastname);

    public List<Professor> searchByFirstnameOrLastname(String firstname, String lastname);

    public List<Professor> searchByEmail(String email);
    public List<Professor> searchByCin (String cin);


}
