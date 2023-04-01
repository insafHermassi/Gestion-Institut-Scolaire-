package com.NSTGroupe.institut.controller;

import com.NSTGroupe.institut.entities.Speciality;
import com.NSTGroupe.institut.entities.User;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/speciality")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class SpecialityController extends BasicController{
    @Autowired
    SpecialityService specialityService;

    @GetMapping(value = "welcome_speciality")
    public String welcome () {
        return ("Welcome, I'am a robot. I will help you to manage Speciality. ");
    }

    @PostMapping
    public Speciality createSpeciality(@Valid @RequestBody Speciality speciality){
        return specialityService.save(speciality);
    }

    @GetMapping("/AllSpeciality")
    public List<Speciality> getSpeciality(){
        return  specialityService.getAllSpeciality();
    }

    @GetMapping(value = "/{id}")
    public Speciality getSpeciality(@PathVariable("id") long id)throws ResourceNotFound {
        return specialityService.getSpeciality(id);
    }

    @GetMapping(value = "/get")
    public Speciality getSpecialityByParam(@RequestParam("id") long id) throws ResourceNotFound {
        return specialityService.getSpeciality(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteSpeciality(@RequestParam("id") long id){
        return  specialityService.deleteSpeciality(id);
    }

    @PutMapping
    public Speciality updateSpeciality(@RequestParam("id") long id, @Valid @RequestBody Speciality speciality) throws ResourceNotFound {
        return specialityService.updateSpeciality(id, speciality);
    }

    @GetMapping(value = "/searchByName_speciality")
    public List<Speciality> getByName_speciality(@RequestParam("searchByName_speciality") String name_speciality){
        return specialityService.searchByName_speciality(name_speciality);
    }



    @GetMapping(value = "/searchByLibelle")
    public List<Speciality> getByLibelle(@RequestParam("libelle") String libelle){
        return specialityService.searchByLibelle(libelle);
    }


}
