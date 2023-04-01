package com.NSTGroupe.institut.controller;


import com.NSTGroupe.institut.entities.Module;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/modules")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ModuleController  extends BasicController{
    @Autowired
    ModuleService moduleService;

    @GetMapping(value = "welcome_Module")
    public String welcome () {
        return ("Welcome, I'am a robot. I will help you to manage modules. ");
    }
    @PostMapping
    public Module createModule(@Valid @RequestBody Module module){
        return moduleService.save(module);
    }
    @GetMapping("/AllModules")
    public List<Module> getModules(){
        return moduleService.getAllModules();
    }
    @GetMapping(value = "/{id}")
    public Module getModule(@PathVariable("id") long id) throws ResourceNotFound {
        return moduleService.getModule(id);
    }
    @GetMapping(value = "/get")
    public Module getModuleByParam(@RequestParam("id") long id) throws ResourceNotFound {
        return moduleService.getModule(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteModule(@RequestParam("id") long id){
        return  moduleService.deleteModule(id);
    }

    @PutMapping
    public Module updateModule(@RequestParam("id") long id, @Valid @RequestBody Module module) throws ResourceNotFound {
        return moduleService.updateModule(id, module);
    }

    @GetMapping(value = "/searchByName_module")
    public List<Module> getByName_module(@RequestParam("name_module") String name_module){
        return moduleService.searchByName_module(name_module);
    }


}

