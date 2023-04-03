package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Sector;
import com.NSTGroupe.institut.entities.Speciality;
import com.NSTGroupe.institut.exception.ResourceNotFound;

import java.util.List;
import java.util.Map;

public interface SectorService {
    public Sector save(Sector sector);
    public Sector getSector(long id) throws ResourceNotFound;
    public List<Sector> getAllSector();

    public Map<String, Boolean> deleteSector(long id);
    public Sector updateSector (long id, Sector sector) throws ResourceNotFound;
    public List<Sector> searchByName_sector(String name_sector);
}
