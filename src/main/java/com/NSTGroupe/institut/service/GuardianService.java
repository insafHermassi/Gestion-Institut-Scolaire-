package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Guardian;
import com.NSTGroupe.institut.exception.ResourceNotFound;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface GuardianService {

    public Guardian save(Guardian guardian);
    public Guardian getGuardian(long id) throws ResourceNotFound;
    public List<Guardian> getAllGuardians();
    public Map<String,Boolean> deleteGuardian(long id);
    public Guardian updateGuardian(long id, Guardian guardian) throws  ResourceNotFound;
    public List<Guardian> searchByCin (String cin);
    public List<Guardian> searchByStartDateOfWork(Date startDateOfWork);
}
