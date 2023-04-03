package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Module;
import com.NSTGroupe.institut.entities.User;
import com.NSTGroupe.institut.exception.ResourceNotFound;

import java.util.List;
import java.util.Map;

public interface ModuleService {
    public Module save(Module module);
    public Module getModule(long id) throws ResourceNotFound;
    public List<Module> getAllModules();

    public Map<String, Boolean> deleteModule (long id);
    public Module updateModule (long id, Module module) throws ResourceNotFound;
    public List<Module> searchByName_module(String name_module);
}
