package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Administrator;
import com.NSTGroupe.institut.entities.Guardian;
import com.NSTGroupe.institut.entities.Responsible;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.repository.ResponsibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResponsibleServiceImpl implements ResponsibleService {
    @Autowired
    ResponsibleRepository responsibleRepository;

    @Override
    public Responsible save(Responsible responsible) {
        return responsibleRepository.save(responsible);
    }

    @Override
    public Responsible getResponsible(long id) throws ResourceNotFound {
        Responsible responsible=responsibleRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("responsible not found for id: "+id)
        );
        return responsible;
    }

    @Override
    public List<Responsible> getAllResponsibles() {
        return (List<Responsible>) responsibleRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteResponsible(long id) {
        responsibleRepository.deleteById(id);
        Map<String,Boolean> res=new HashMap<>();
        res.put("deleted_responsible",Boolean.TRUE);
        return res;     }

    @Override
    public Responsible updateResponsible(long id, Responsible responsible) throws ResourceNotFound {
        Responsible old=getResponsible(id);
        old.setCin(responsible.getCin());
        return responsibleRepository.save(old);    }

    @Override
    public List<Responsible> searchByCin(String cin) {
        return responsibleRepository.findByCin(cin);
    }
}
