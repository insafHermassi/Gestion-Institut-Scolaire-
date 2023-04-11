package com.NSTGroupe.institut.controller;

import com.NSTGroupe.institut.entities.Administrator;
import com.NSTGroupe.institut.entities.Secretary;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.service.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Secretarys")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class SecretaryController extends BasicController{


    @Autowired
    SecretaryService secretaryService;

    @GetMapping(value = "welcome_Secretary")
    public String welcome () {
        return ("Welcome, I'am a robot. I will help you to manage Secretarys. ");
    }
    @PostMapping
    public Secretary createSecretary(@Valid @RequestBody Secretary secretary){
        return secretaryService.save(secretary);
    }
    @GetMapping("/AllSecretarys")
    public List<Secretary> getSecretarys(){
        return secretaryService.getAllSecretarys();
    }
    @GetMapping(value = "/{id}")
    public Secretary getSecretary(@PathVariable("id") long id) throws ResourceNotFound {
        return secretaryService.getSecretary(id);
    }
    @GetMapping(value = "/get")
    public Secretary getSecretaryByParam(@RequestParam("id") long id) throws ResourceNotFound {
        return secretaryService.getSecretary(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteSecretary(@RequestParam("id") long id){
        return  secretaryService.deleteSecretary(id);
    }

    @PutMapping
    public Secretary updateSecretary(@RequestParam("id") long id, @Valid @RequestBody Secretary secretary) throws ResourceNotFound {
        return secretaryService.updateSecretary(id, secretary);
    }
    @GetMapping(value ="/searchByCin")
    public List<Secretary> searchByCin(@RequestParam("cin")String cin) {
        return secretaryService.searchByCin(cin);
    }


    @GetMapping(value ="/searchByStartDateOfWork")
    public List<Secretary> searchByStartDateOfWork(@RequestParam("startDateOfWork") Date startDateOfWork) {
        return secretaryService.searchByStartDateOfWork(startDateOfWork);
    }
}

