package com.NSTGroupe.institut.controller;

import com.NSTGroupe.institut.entities.Responsible;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.service.ResponsibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Responsibles")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ResponsibleController extends BasicController{

    @Autowired
    ResponsibleService responsibleService;

    @GetMapping(value = "welcome_Responsible")
    public String welcome () {
        return ("Welcome, I'am a robot. I will help you to manage Responsibles. ");
    }
    @PostMapping
    public Responsible createResponsible(@Valid @RequestBody Responsible responsible){
        return responsibleService.save(responsible);
    }
    @GetMapping("/AllResponsibles")
    public List<Responsible> getResponsibles(){
        return responsibleService.getAllResponsibles();
    }
    @GetMapping(value = "/{id}")
    public Responsible getResponsible(@PathVariable("id") long id) throws ResourceNotFound {
        return responsibleService.getResponsible(id);
    }
    @GetMapping(value = "/get")
    public Responsible getResponsibleByParam(@RequestParam("id") long id) throws ResourceNotFound {
        return responsibleService.getResponsible(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteResponsible(@RequestParam("id") long id){
        return  responsibleService.deleteResponsible(id);
    }

    @PutMapping
    public Responsible updateResponsible(@RequestParam("id") long id, @Valid @RequestBody Responsible responsible) throws ResourceNotFound {
        return responsibleService.updateResponsible(id, responsible);
    }
    @GetMapping(value ="/searchByCin")
    public List<Responsible> searchByCin(@RequestParam("cin")String cin) {
        return responsibleService.searchByCin(cin);

}

}
