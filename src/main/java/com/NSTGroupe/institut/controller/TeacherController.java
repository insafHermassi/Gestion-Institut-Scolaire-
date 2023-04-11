package com.NSTGroupe.institut.controller;

import com.NSTGroupe.institut.entities.Teacher;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teachers")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class TeacherController extends BasicController{

    @Autowired
    TeacherService teacherService;

    @GetMapping(value = "welcome_Teacher")
        public String welcome () {
            return ("Welcome, I'am a robot. I will help you to manage Teachers. ");
        }
    @PostMapping
    public Teacher createTeacher(@Valid @RequestBody Teacher teacher){
        return teacherService.save(teacher);
    }
    @GetMapping("/AllTeachers")
    public List<Teacher> getTeachers(){
        return teacherService.getAllTeachers();
    }
    @GetMapping(value = "/{id}")
    public Teacher getTeacher(@PathVariable("id") long id) throws ResourceNotFound{
        return teacherService.getTeacher(id);
    }
    @GetMapping(value = "/get")
    public Teacher getTeacherByParam(@RequestParam("id") long id) throws ResourceNotFound {
        return teacherService.getTeacher(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteTeacher(@RequestParam("id") long id){
        return  teacherService.deleteTeacher(id);
    }

    @PutMapping
    public Teacher updateTeacher(@RequestParam("id") long id, @Valid @RequestBody Teacher teacher) throws ResourceNotFound {
        return teacherService.updateTeacher(id, teacher);
    }
    @GetMapping(value ="/searchByCin")
    public List<Teacher> searchByCin(@RequestParam("cin")String cin) {
        return teacherService.searchByCin(cin);
    }

    @GetMapping(value ="/searchByDiploma")
    public List<Teacher> searchByDiploma(@RequestParam("diploma")String diploma) {
        return teacherService.searchByDiploma(diploma);
    }

@GetMapping(value ="/searchByStartDateOfWork")
public List<Teacher> searchByStartDateOfWork(@RequestParam("startDateOfWork") Date startDateOfWork) {
        return teacherService.searchByStartDateOfWork(startDateOfWork);

        }
}