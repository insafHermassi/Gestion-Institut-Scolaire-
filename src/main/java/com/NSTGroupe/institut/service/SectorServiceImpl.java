package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Sector;
import com.NSTGroupe.institut.entities.Speciality;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SectorServiceImpl implements SectorService {
    @Autowired
    SectorRepository sectorRepository;
    @Override
    public Sector save(Sector sector) {
        return sectorRepository.save(sector);
    }

    @Override
    public Sector getSector(long id) throws ResourceNotFound {
         Sector sector=sectorRepository.findById(id).orElseThrow(
                 ()-> new ResourceNotFound("sector not found for id:"+id));
        return sector;

    }

    @Override
    public List<Sector> getAllSector() {
        return (List<Sector>) sectorRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteSector(long id) {
        sectorRepository.deleteById(id);
        Map<String,Boolean> res=new HashMap<>();
        res.put("deleted_sector",Boolean.TRUE);
        return res;
}

    @Override
    public Sector updateSector(long id, Sector sector) throws ResourceNotFound {
        Sector old=getSector(id);
        old.setName_sector(sector.getName_sector());
        return sectorRepository.save(old);
    }

    @Override
    public List<Sector> searchByName_sector(String name_sector) {
        return sectorRepository.findByName_sector(name_sector);
    }
}
