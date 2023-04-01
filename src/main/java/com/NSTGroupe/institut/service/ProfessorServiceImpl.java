package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Professor;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProfessorServiceImpl  implements ProfessorService{

    @Autowired
    ProfessorRepository professorRepository;

    @Override
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor getProfessor(long id) throws ResourceNotFound {
        Professor professor=professorRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("professor not found for id: "+id)
        );
        return professor ;
    }

    @Override
    public List<Professor> getAllProfessors() {
        return (List<Professor>) professorRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteProfessor(long id) {
        professorRepository.deleteById(id);
        Map<String,Boolean> res=new HashMap<>();
        res.put("deleted_professor",Boolean.TRUE);
        return res;
    }

    @Override
    public Professor updateProfessor(long id, Professor professor) throws ResourceNotFound {
        Professor old=getProfessor(id);
        old.setFirstname(professor.getFirstname());
        old.setLastname(professor.getLastname());
        old.setEmail(professor.getEmail());
        old.setCin(professor.getCin());
        old.setTel(professor.getTel());
        old.setAdresse(professor.getAdresse());
        old.setDate_of_birth(professor.getDate_of_birth());
        old.setLieu(professor.getLieu());
        old.setGenre(professor.getGenre());
        old.setNationality(professor.getNationality());
        old.setGrade(professor.getGrade());
        old.setEstablishment(professor.getEstablishment());
        return professorRepository.save(old);
    }

    @Override
    public List<Professor> searchByFirstname(String firstname) {
        return professorRepository.findByFirstname(firstname);
    }
    @Override
    public List<Professor> searchByLastname(String lastname) {
        return professorRepository.findByLastname(lastname);
    }

    @Override
    public List<Professor> searchByFirstnameOrLastname(String firstname, String lastname) {
        return professorRepository.findByFirstnameOrLastname(firstname, lastname);
    }

    @Override
    public List<Professor> searchByEmail(String email) {
        return professorRepository.findByEmail(email);
    }

    @Override
    public List<Professor> searchByCin(String cin) {
        return professorRepository.findByCin(cin);
    }
}
