package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Student;
import com.NSTGroupe.institut.entities.User;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student save(Student student) {
        return studentRepository.save(student) ;
    }

    @Override
    public Student getStudent(long id) throws ResourceNotFound {

        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("user not found for id: " + id)
        );
        return student;
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteStudent(long id) {
        studentRepository.deleteById(id);
        Map<String, Boolean> res= new HashMap<>();
        res.put("deleted_student", Boolean.TRUE);
        return res;
    }

    @Override
    public Student updateStudent(long id, Student student) throws ResourceNotFound {
        Student old = getStudent(id);
        old.setFirstname(student.getFirstname());
        old.setLastname(student.getLastname());
        return studentRepository.save(old);
    }

    @Override
    public List<Student> searchByFirstname(String firstname) {
        return studentRepository.findByFirstname(firstname);
    }

    @Override
    public List<Student> searchByLastname(String lastname) {
        return studentRepository.findByLastname(lastname);
    }

    @Override
    public List<Student> searchByFirstnameOrLastname(String firstname, String lastname) {
        return studentRepository.findByFirstnameOrLastname(firstname, lastname);
    }

    @Override
   public List<Student> searchByEmail(String email) {return studentRepository.findByEmail(email);
    }

    @Override
    public List<Student> searchByNationality(String nationality) {
        return studentRepository.findByNationality(nationality);
    }

    @Override
    public List<Student> searchByGender(String gender) {
        return studentRepository.findByGender(gender);
    }
}
