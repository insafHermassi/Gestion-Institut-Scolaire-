package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Administrator;
import com.NSTGroupe.institut.entities.Guardian;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.repository.GuardianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GuardianServiceImpl implements GuardianService{

    @Autowired
    GuardianRepository guardianRepository;

    @Override
    public Guardian save(Guardian guardian) {
        return guardianRepository.save(guardian);
    }

    @Override
    public Guardian getGuardian(long id) throws ResourceNotFound {
        Guardian guardian=guardianRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("guardian not found for id: "+id)
        );
        return guardian;    }

    @Override
    public List<Guardian> getAllGuardians() {
        return (List<Guardian>) guardianRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteGuardian(long id) {
        guardianRepository.deleteById(id);
        Map<String,Boolean> res=new HashMap<>();
        res.put("deleted_guardian",Boolean.TRUE);
        return res;       }

    @Override
    public Guardian updateGuardian(long id, Guardian guardian) throws ResourceNotFound {
        Guardian old=getGuardian(id);
        old.setCin(guardian.getCin());
        old.setStartDateOfWork(guardian.getStartDateOfWork());
        return guardianRepository.save(old);
    }

    @Override
    public List<Guardian> searchByCin(String cin) {
        return guardianRepository.findByCin(cin);
    }

    @Override
    public List<Guardian> searchByStartDateOfWork(Date startDateOfWork) {
        return guardianRepository.findByStartDateOfWork(startDateOfWork);
    }
}
