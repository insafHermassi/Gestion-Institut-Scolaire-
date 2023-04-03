package com.NSTGroupe.institut.controller;

import com.NSTGroupe.institut.entities.Professor;
import com.NSTGroupe.institut.entities.User;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/professors")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ProfessorController  extends BasicController{

    @Autowired
    ProfessorService professorService;

    @GetMapping(value = "welcome_Professor")
        public String welcome () {
            return ("Welcome, I'am a robot. I will help you to manage Professors. ");
        }
    @PostMapping
    public Professor createProfessor(@Valid @RequestBody Professor professor){
        return professorService.save(professor);
    }
    @GetMapping("/AllProfessors")
    public List<Professor> getProfessors(){
        return professorService.getAllProfessors();
    }
    @GetMapping(value = "/{id}")
    public Professor getProfessor(@PathVariable("id") long id) throws ResourceNotFound{
        return professorService.getProfessor(id);
    }
    @GetMapping(value = "/get")
    public Professor getProfessorByParam(@RequestParam("id") long id) throws ResourceNotFound {
        return professorService.getProfessor(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteProfessor(@RequestParam("id") long id){
        return  professorService.deleteProfessor(id);
    }

    @PutMapping
    public Professor updateProfessor(@RequestParam("id") long id, @Valid @RequestBody Professor professor) throws ResourceNotFound {
        return professorService.updateProfessor(id, professor);
    }

    @GetMapping(value = "/searchByFirstname")
    public List<Professor> getByFirstname(@RequestParam("firstname") String firstname){
        return professorService.searchByFirstname(firstname);
    }

    @GetMapping(value = "/searchByLastname")
    public List<Professor> getByLastname(@RequestParam("lastname") String lastname){
        return professorService.searchByLastname(lastname);
    }
   @GetMapping(value ="/searchByFirstnameOrLastname")
   public List<Professor> searchByFirstnameOrLastname(@RequestParam("lastname,firstname")String firstname, String lastname) {
          return professorService.searchByFirstnameOrLastname(firstname, lastname);
   }
    @GetMapping(value = "/searchByEmail")
    public List<Professor> getByEmail(@RequestParam("email") String email){
        return professorService.searchByEmail(email);
    }
    @GetMapping(value ="/searchByCin")
    public List<Professor> searchByCin(@RequestParam("cin")String cin) {
        return professorService.searchByCin(cin);
    }
}
