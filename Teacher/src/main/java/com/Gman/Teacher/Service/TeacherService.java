package com.Gman.Teacher.Service;

import com.Gman.Teacher.Handler.ResourceNotFound;
import com.Gman.Teacher.Models.Teacher;
import com.Gman.Teacher.Repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    public void addTeacher(Teacher teacher){
        teacherRepo.save(teacher);
    }

    public Iterable<Teacher> getAllTeacher(){
        return teacherRepo.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id){
        return teacherRepo.findById(id);
    }

    public void updateTeacher(Long id, Teacher teacher){
        teacher.setId(id);
        teacherRepo.save(teacher);
    }

    public void deleteTeacher(Long id){
        teacherRepo.deleteById(id);
    }

    public Teacher findATeacherByName(String name){
        return teacherRepo.findByName(name);
    }

    public void verifyTeacher(Long id) throws ResourceNotFound {
        Optional<Teacher> teacher = teacherRepo.findById(id);
        if(teacher.isEmpty()) {
            throw new ResourceNotFound("Teacher with id " + id + " not found");
        }
    }

}
