package com.NSTGroupe.institut.controller;

import com.NSTGroupe.institut.entities.Administrator;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/administrators")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class AdministratorController extends BasicController{


    @Autowired
    AdministratorService administratorService;

    @GetMapping(value = "welcome_Administrator")
    public String welcome () {
        return ("Welcome, I'am a robot. I will help you to manage Administrators. ");
    }
    @PostMapping
    public Administrator createAdministrator(@Valid @RequestBody Administrator administrator){
        return administratorService.save(administrator);
    }
    @GetMapping("/AllAdministrators")
    public List<Administrator> getAdministrators(){
        return administratorService.getAllAdministrators();
    }
    @GetMapping(value = "/{id}")
    public Administrator getAdministrator(@PathVariable("id") long id) throws ResourceNotFound {
        return administratorService.getAdministrator(id);
    }
    @GetMapping(value = "/get")
    public Administrator getAdministratorByParam(@RequestParam("id") long id) throws ResourceNotFound {
        return administratorService.getAdministrator(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteAdministrator(@RequestParam("id") long id){
        return  administratorService.deleteAdministrator(id);
    }

    @PutMapping
    public Administrator updateAdministrator(@RequestParam("id") long id, @Valid @RequestBody Administrator administrator) throws ResourceNotFound {
        return administratorService.updateAdministrator(id, administrator);
    }
    @GetMapping(value ="/searchByCin")
    public List<Administrator> searchByCin(@RequestParam("cin")String cin) {
        return administratorService.searchByCin(cin);
    }


    @GetMapping(value ="/searchByStartDateOfWork")
    public List<Administrator> searchByStartDateOfWork(@RequestParam("startDateOfWork") Date startDateOfWork) {
        return administratorService.searchByStartDateOfWork(startDateOfWork);
    }
}
