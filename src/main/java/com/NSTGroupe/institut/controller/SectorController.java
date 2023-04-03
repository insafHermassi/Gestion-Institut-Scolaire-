package com.NSTGroupe.institut.controller;

import com.NSTGroupe.institut.entities.Module;
import com.NSTGroupe.institut.entities.Sector;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sectors")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class SectorController extends BasicController {
    @Autowired
    SectorService sectorService;

    @GetMapping(value = "Sector")
    public String welcome () {
        return ("Welcome, I'am a robot. I will help you to manage sectors. ");
    }
    @PostMapping
    public Sector createSector(@Valid @RequestBody Sector sector){
        return sectorService.save(sector);
    }
    @GetMapping("/AllSectors")
    public List<Sector> getSectors(){
        return sectorService.getAllSector();
    }
    @GetMapping(value = "/{id}")
    public Sector getSector(@PathVariable("id") long id) throws ResourceNotFound {
        return sectorService.getSector(id);
    }
    @GetMapping(value = "/get")
    public Sector getSectorByParam(@RequestParam("id") long id) throws ResourceNotFound {
        return sectorService.getSector(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteSector(@RequestParam("id") long id){
        return  sectorService.deleteSector(id);
    }

    @PutMapping
    public Sector updateSector(@RequestParam("id") long id, @Valid @RequestBody Sector sector) throws ResourceNotFound {
        return sectorService.updateSector(id, sector);
    }

    @GetMapping(value = "/searchByName_sector")
    public List<Sector> getByName_sector(@RequestParam("name_sector") String name_sector){
        return sectorService.searchByName_sector(name_sector);
    }
}
