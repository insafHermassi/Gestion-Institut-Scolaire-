package com.NSTGroupe.institut.service;


import com.NSTGroupe.institut.entities.Teacher;
import com.NSTGroupe.institut.exception.ResourceNotFound;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TeacherService {

    public Teacher save(Teacher teacher);
    public Teacher getTeacher(long id) throws ResourceNotFound;
    public List<Teacher> getAllTeachers();
    public Map<String,Boolean> deleteTeacher(long id);
    public Teacher updateTeacher(long id, Teacher teacher) throws  ResourceNotFound;
    public List<Teacher> searchByCin (String cin);
    public List<Teacher> searchByDiploma(String diploma);

    public List<Teacher> searchByStartDateOfWork(Date st);


}
