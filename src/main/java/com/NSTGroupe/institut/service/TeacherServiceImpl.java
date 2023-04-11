package com.NSTGroupe.institut.service;

import com.NSTGroupe.institut.entities.Teacher;
import com.NSTGroupe.institut.exception.ResourceNotFound;
import com.NSTGroupe.institut.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacher(long id) throws ResourceNotFound {
         Teacher teacher=teacherRepository.findById(id).orElseThrow(
                 ()-> new ResourceNotFound("teacher not found for id: "+id)
         );
         return teacher;
    }
    @Override
    public List<Teacher> getAllTeachers() {

        return (List<Teacher>) teacherRepository.findAll();
    }
    @Override
    public Map<String, Boolean> deleteTeacher(long id) {
        teacherRepository.deleteById(id);
        Map<String,Boolean> res=new HashMap<>();
        res.put("deleted_teacher",Boolean.TRUE);
        return res;
    }
    @Override
    public Teacher updateTeacher(long id, Teacher teacher) throws ResourceNotFound {
          Teacher old=getTeacher(id);
          old.setCin(teacher.getCin());
          old.setDiploma(teacher.getDiploma());
          old.setStartDateOfWork(teacher.getStartDateOfWork());
          return teacherRepository.save(old);
    }


    @Override
    public List<Teacher> searchByCin(String cin) {
        return teacherRepository.findByCin(cin);
    }

    @Override
    public List<Teacher> searchByDiploma(String diploma) {
        return teacherRepository.findByDiploma(diploma);
    }

    @Override
    public List<Teacher> searchByStartDateOfWork(Date startDateOfWork) {
        return teacherRepository.findByStartDateOfWork(startDateOfWork);
    }
}
