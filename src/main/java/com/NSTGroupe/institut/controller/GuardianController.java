package com.NSTGroupe.institut.controller;

import com.NSTGroupe.institut.entities.Administrator;
import com.NSTGroupe.institut.entities.Guardian;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/guardians")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class GuardianController extends BasicController {

    @Autowired
    GuardianService guardianService;

    @GetMapping(value = "welcome_Guardian")
    public String welcome () {
        return ("Welcome, I'am a robot. I will help you to manage  Guardians. ");
    }
    @PostMapping
    public Guardian createGuardian(@Valid @RequestBody  Guardian guardian){
        return guardianService.save(guardian);
    }
    @GetMapping("/AllGuardians")
    public List<Guardian> getGuardians(){
        return guardianService.getAllGuardians();
    }
    @GetMapping(value = "/{id}")
    public  Guardian getGuardian(@PathVariable("id") long id) throws ResourceNotFound {
        return guardianService.getGuardian(id);
    }
    @GetMapping(value = "/get")
    public Guardian getGuardianByParam(@RequestParam("id") long id) throws ResourceNotFound {
        return guardianService.getGuardian(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteGuardian(@RequestParam("id") long id){
        return  guardianService.deleteGuardian(id);
    }

    @PutMapping
    public Guardian updateGuardian(@RequestParam("id") long id, @Valid @RequestBody Guardian guardian) throws ResourceNotFound {
        return guardianService.updateGuardian(id, guardian);
    }
    @GetMapping(value ="/searchByCin")
    public List<Guardian> searchByCin(@RequestParam("cin")String cin) {
        return guardianService.searchByCin(cin);
    }


    @GetMapping(value ="/searchByStartDateOfWork")
    public List<Guardian> searchByStartDateOfWork(@RequestParam("startDateOfWork") Date startDateOfWork) {
        return guardianService.searchByStartDateOfWork(startDateOfWork);
    }
}


