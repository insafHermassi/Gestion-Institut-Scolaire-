package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Guardian;
import com.NSTGroupe.institut.entities.Secretary;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.repository.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SecretaryServiceImpl implements SecretaryService{

    @Autowired
    SecretaryRepository secretaryRepository;

    @Override
    public Secretary save(Secretary secretary) {
        return secretaryRepository.save(secretary);
    }

    @Override
    public Secretary getSecretary(long id) throws ResourceNotFound {
        Secretary secretary=secretaryRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("secretary not found for id: "+id)
        );
        return secretary;     }

    @Override
    public List<Secretary> getAllSecretarys() {
        return (List<Secretary>) secretaryRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteSecretary(long id) {
        secretaryRepository.deleteById(id);
        Map<String,Boolean> res=new HashMap<>();
        res.put("deleted_secretary",Boolean.TRUE);
        return res;     }

    @Override
    public Secretary updateSecretary(long id, Secretary secretary) throws ResourceNotFound {
        Secretary old=getSecretary(id);
        old.setCin(secretary.getCin());
        old.setStartDateOfWork(secretary.getStartDateOfWork());
        return secretaryRepository.save(old);    }

    @Override
    public List<Secretary> searchByCin(String cin) {
        return secretaryRepository.findByCin(cin);
    }

    @Override
    public List<Secretary> searchByStartDateOfWork(Date startDateOfWork) {
        return secretaryRepository.findByStartDateOfWork(startDateOfWork);
    }
}
