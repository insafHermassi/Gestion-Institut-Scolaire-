package com.NSTGroupe.institut.controller;

import com.NSTGroupe.institut.entities.Student;
import com.NSTGroupe.institut.entities.User;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.service.StudentService;
import com.NSTGroupe.institut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/students")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class StudentController  extends  BasicController{

        @Autowired
    StudentService studentService;

        @PostMapping
        public Student createStudent(@Valid @RequestBody Student student){
            return studentService.save(student);
        }

        @GetMapping("/AllStudents")
        public List<Student> getStudents(){
            return  studentService.getAllStudents();
        }

        @GetMapping(value = "/{id}")
        public User getStudent(@PathVariable("id") long id)throws ResourceNotFound {
            return studentService.getStudent(id);
        }

        @GetMapping(value = "/get")
        public Student getStudentByParam(@RequestParam("id") long id) throws ResourceNotFound {
            return studentService.getStudent(id);
        }

        @DeleteMapping
        public Map<String,Boolean> deleteStudent(@RequestParam("id") long id){
            return studentService.deleteStudent(id);
        }

        @PutMapping
        public User updateStudent(@RequestParam("id") long id, @Valid @RequestBody Student student) throws ResourceNotFound {
            return studentService.updateStudent(id, student);
        }

        @GetMapping(value = "/searchByStudent_Firstname")
        public List<Student> getByFirstname(@RequestParam("Student_firstname") String firstname){
            return studentService.searchByFirstname(firstname);
        }

        @GetMapping(value = "/searchByStudent_Lastname")
        public List<Student> getByLastname(@RequestParam("User_lastname") String lastname){
            return studentService.searchByLastname(lastname);
        }

        @GetMapping(value = "/searchByStudent_Firstname_Or_Lastname")
        public List<Student> getByFirstnameOrLastname(@RequestParam("Student_name") String firstname, String lastname){
            return studentService.searchByFirstnameOrLastname(firstname, lastname);
        }

        @GetMapping(value = "/searchByEmail")
        public List<Student> getByEmail(@RequestParam("User_email") String email){
            return studentService.searchByEmail(email);
        }

    }
