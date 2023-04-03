package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Student;
import com.NSTGroupe.institut.entities.User;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface StudentService{
    public Student save(Student student);
    public Student getStudent(long id) throws ResourceNotFound;
    public List<Student> getAllStudents();

    public Map<String, Boolean> deleteStudent (long id);
    public Student updateStudent (long id, Student student) throws ResourceNotFound;
    public List<Student> searchByFirstname (String firstname);
    public List<Student> searchByLastname (String lastname);
    public List<Student> searchByFirstnameOrLastname (String firstname, String lastname);
    public List<Student> searchByEmail (String email);
    public List<Student> searchByNationality(String nationality);

    public List<Student> searchByGender(String gender);
}
