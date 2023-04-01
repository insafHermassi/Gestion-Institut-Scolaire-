package com.NSTGroupe.institut.controller;

import com.NSTGroupe.institut.entities.Level;
import com.NSTGroupe.institut.entities.Module;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/levels")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class LevelController extends BasicController {
    @Autowired
    LevelService levelService;
    @GetMapping(value = "welcome_Level")
    public String welcome () {
        return ("Welcome, I'am a robot. I will help you to manage levels. ");
    }
    @PostMapping
    public Level createLevel(@Valid @RequestBody Level level){
        return levelService.save(level);
    }
    @GetMapping("/AllLevels")
    public List<Level> getLevels(){
        return levelService.getAllLevels();
    }
    @GetMapping(value = "/{id}")
    public Level getLevel(@PathVariable("id") long id) throws ResourceNotFound {
        return levelService.getLevel(id);
    }
    @GetMapping(value = "/get")
    public Level getLevelByParam(@RequestParam("id") long id) throws ResourceNotFound {
        return levelService.getLevel(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteLevel(@RequestParam("id") long id){
        return  levelService.deleteLevel(id);
    }

    @PutMapping
    public Level updateLevel(@RequestParam("id") long id, @Valid @RequestBody Level level) throws ResourceNotFound {
        return levelService.updateLevel(id, level);
    }

    @GetMapping(value = "/searchByLibelle")
    public List<Level> getByLibelle(@RequestParam("libelle") String libelle){
        return levelService.searchByLibelle(libelle);
    }
    @GetMapping(value = "/searchByOption")
    public List<Level> getByOption(@RequestParam("option") String option) {
        return levelService.searchByOption(option);
    }


}
