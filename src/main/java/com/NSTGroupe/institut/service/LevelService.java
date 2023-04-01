package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Level;
import com.NSTGroupe.institut.entities.Module;
import com.NSTGroupe.institut.exception.ResourceNotFound;

import java.util.List;
import java.util.Map;

public interface LevelService {
    public Level save(Level level);
    public Level getLevel(long id) throws ResourceNotFound;
    public List<Level> getAllLevels();

    public Map<String, Boolean> deleteLevel (long id);
    public Level updateLevel (long id, Level level) throws ResourceNotFound;
    public List<Level> searchByLibelle(String libelle);
    public List<Level> searchByOption (String option);

}
