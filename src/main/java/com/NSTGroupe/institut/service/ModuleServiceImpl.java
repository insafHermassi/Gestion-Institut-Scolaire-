package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Module;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    ModuleRepository moduleRepository;
    @Override
    public Module save(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public Module getModule(long id) throws ResourceNotFound {
        Module module=moduleRepository.findById(id).orElseThrow((
                ()-> new ResourceNotFound("module not found for id: "+id)
        ));
        return module;
    }

    @Override
    public List<Module> getAllModules() {

        return (List<Module>) moduleRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteModule(long id) {
        moduleRepository.deleteById(id);
        Map<String, Boolean> res= new HashMap<>();
        res.put("deleted_module", Boolean.TRUE);
        return res;
    }

    @Override
    public Module updateModule(long id, Module module) throws ResourceNotFound {
      Module old=getModule(id);
      old.setName_module(module.getName_module());
      old.setCoefficient(module.getCoefficient());
      old.setNb_semester(module.getNb_semester());
      old.setCredit(module.getCredit());
        return moduleRepository.save(old);
    }

    @Override
    public List<Module> searchByName_module(String name_module) {
        return moduleRepository.findByName_module(name_module);
    }
}
