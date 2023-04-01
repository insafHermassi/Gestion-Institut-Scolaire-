package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Speciality;
import com.NSTGroupe.institut.entities.User;
import com.NSTGroupe.institut.exception.ResourceNotFound;

import java.util.List;
import java.util.Map;

public interface SpecialityService {
    public Speciality save(Speciality speciality);
    public Speciality getSpeciality(long id) throws ResourceNotFound;
    public List<Speciality> getAllSpeciality();

    public Map<String, Boolean> deleteSpeciality (long id);
    public Speciality updateSpeciality (long id, Speciality speciality) throws ResourceNotFound;
    public List<Speciality> searchByName_speciality (String name_speciality);

    public List<Speciality> searchByLibelle(String libelle);

}
