package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Level;
import com.NSTGroupe.institut.entities.Module;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
        Level level=levelRepository.findById(id).orElseThrow((
                ()-> new ResourceNotFound("level not found for id: "+id)
        ));
        return level;    }

    @Override
    public List<Level> getAllLevels() {
        return (List<Level>) levelRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteLevel(long id) {
        levelRepository.deleteById(id);
        Map<String, Boolean> res= new HashMap<>();
        res.put("deleted_level", Boolean.TRUE);
        return res;    }

    @Override
    public Level updateLevel(long id, Level level) throws ResourceNotFound {
        Level old=getLevel(id);
        old.setLibellle(level.getLibellle());
        old.setOption(level.getOption());
        return levelRepository.save(old);    }

    @Override
    public List<Level> searchByLibelle(String libelle) {
        return levelRepository.findByLibelle(libelle);
   }

    @Override
    public List<Level> searchByOption(String option) {

        return levelRepository.findByOption(option);
    }
}
