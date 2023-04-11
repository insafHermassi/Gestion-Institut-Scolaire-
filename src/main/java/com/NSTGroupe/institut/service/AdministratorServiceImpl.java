package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Administrator;
import com.NSTGroupe.institut.entities.Teacher;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdministratorServiceImpl implements AdministratorService{

    @Autowired
    AdministratorRepository administratorRepository;

    @Override
    public Administrator save(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    @Override
    public Administrator getAdministrator(long id) throws ResourceNotFound {
        Administrator administrator=administratorRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("administrator not found for id: "+id)
        );
        return administrator;
    }

    @Override
    public List<Administrator> getAllAdministrators() {
        return (List<Administrator>) administratorRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteAdministrator(long id) {
        administratorRepository.deleteById(id);
        Map<String,Boolean> res=new HashMap<>();
        res.put("deleted_administrator",Boolean.TRUE);
        return res;    }

    @Override
    public Administrator updateAdministrator(long id, Administrator administrator) throws ResourceNotFound {
        Administrator old=getAdministrator(id);
        old.setCin(administrator.getCin());
        old.setStartDateOfWork(administrator.getStartDateOfWork());
        return administratorRepository.save(old);    }

    @Override
    public List<Administrator> searchByCin(String cin) {
            return administratorRepository.findByCin(cin);
        }

    @Override
    public List<Administrator> searchByStartDateOfWork(Date startDateOfWork) {
        return administratorRepository.findByStartDateOfWork(startDateOfWork);
    }

}
