package com.NSTGroupe.institut.service;


import com.NSTGroupe.institut.entities.Responsible;
import com.NSTGroupe.institut.exception.ResourceNotFound;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ResponsibleService {

    public Responsible save(Responsible responsible);
    public Responsible getResponsible(long id) throws ResourceNotFound;
    public List<Responsible> getAllResponsibles();
    public Map<String,Boolean> deleteResponsible(long id);
    public Responsible updateResponsible(long id, Responsible responsible) throws  ResourceNotFound;
    public List<Responsible> searchByCin (String cin);

}
