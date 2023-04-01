package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Level;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LevelServiceImpl  implements LevelService{
    @Autowired
    LevelRepository levelRepository;
    @Override
    public Level save(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public Level getLevel(long id) throws ResourceNotFound {
        return null;
    }

    @Override
    public List<Level> getAllLevels() {
        return null;
    }

    @Override
    public Map<String, Boolean> deleteLevel(long id) {
        return null;
    }

    @Override
    public Level updateLevel(long id, Level level) throws ResourceNotFound {
        return null;
    }

    @Override
    public List<Level> searchByLibelle(String libelle) {
        return null;
    }

    @Override
    public List<Level> searchByOption(String option) {
        return null;
    }
}
