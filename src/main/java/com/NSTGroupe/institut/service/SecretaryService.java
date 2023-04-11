package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Secretary;
import com.NSTGroupe.institut.exception.ResourceNotFound;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SecretaryService {


    public Secretary save(Secretary secretary);
    public Secretary getSecretary(long id) throws ResourceNotFound;
    public List<Secretary> getAllSecretarys();
    public Map<String,Boolean> deleteSecretary(long id);
    public Secretary updateSecretary(long id, Secretary secretary) throws  ResourceNotFound;
    public List<Secretary> searchByCin (String cin);
    public List<Secretary> searchByStartDateOfWork(Date startDateOfWork);
}
