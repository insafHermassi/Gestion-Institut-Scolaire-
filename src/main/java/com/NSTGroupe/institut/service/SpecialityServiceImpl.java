package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Speciality;
import com.NSTGroupe.institut.entities.User;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpecialityServiceImpl implements SpecialityService{
    @Autowired
    SpecialityRepository specialityRepository;
    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public Speciality getSpeciality(long id) throws ResourceNotFound {
        Speciality speciality= specialityRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("speciality not found for id:"+id));
        return speciality;
    }

    @Override
    public List<Speciality> getAllSpeciality() {
        return (List<Speciality>) specialityRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteSpeciality(long id) {
        specialityRepository.deleteById(id);
        Map<String,Boolean> res=new HashMap<>();
        res.put("deleted_speciality",Boolean.TRUE);
        return res;
    }

    @Override
    public Speciality updateSpeciality(long id, Speciality speciality) throws ResourceNotFound {
      Speciality old=getSpeciality(id);
      old.setName_speciality(speciality.getName_speciality());
      old.setLibellle(speciality.getLibellle());
      return specialityRepository.save(old);
    }

    @Override
    public List<Speciality> searchByName_speciality(String name_speciality) {
        return specialityRepository.findByName_speciality(name_speciality);
    }

    @Override
    public List<Speciality> searchByLibelle(String libelle) {
        return specialityRepository.findByLibellle(libelle);
    }
}
