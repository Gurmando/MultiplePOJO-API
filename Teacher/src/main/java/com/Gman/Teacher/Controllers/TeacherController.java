package com.Gman.Teacher.Controllers;

import com.Gman.Teacher.Handler.ResourceNotFound;
import com.Gman.Teacher.Models.Teacher;
import com.Gman.Teacher.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/teacher")
    public ResponseEntity<Void> createTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/teacher/{id}")
    public ResponseEntity<Void> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher){
        teacherService.verifyTeacher(id);
        teacherService.updateTeacher(id, teacher);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/teacher/{id}")
    public Optional<Teacher> getTeacherById(@PathVariable Long id) throws ResourceNotFound{
        teacherService.verifyTeacher(id);
        return teacherService.getTeacherById(id);
    }


    @DeleteMapping("/teacher/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id){
        teacherService.verifyTeacher(id);
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/teacher")
    public ResponseEntity<?> getAllOrGetTeacherByName(@RequestParam(value = "name", required = false) String name){

        Teacher teacher = teacherService.findATeacherByName(name);

        if(name != null){
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        }
        return new ResponseEntity<>(teacherService.getAllTeacher(), HttpStatus.OK);

    }


}
