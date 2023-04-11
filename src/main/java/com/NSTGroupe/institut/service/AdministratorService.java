package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Administrator;
import com.NSTGroupe.institut.entities.Teacher;
import com.NSTGroupe.institut.exception.ResourceNotFound;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AdministratorService {
    public Administrator save(Administrator administrator);
    public Administrator getAdministrator(long id) throws ResourceNotFound;
    public List<Administrator> getAllAdministrators();
    public Map<String,Boolean> deleteAdministrator(long id);
    public Administrator updateAdministrator(long id, Administrator administrator) throws  ResourceNotFound;
    public List<Administrator> searchByCin (String cin);

    List<Administrator> searchByStartDateOfWork(Date startDateOfWork);
}
