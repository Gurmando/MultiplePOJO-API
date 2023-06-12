package com.Gman.Teacher.Controllers;

import com.Gman.Teacher.Models.Student;
import com.Gman.Teacher.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController  {

    @Autowired
    private StudentService studentService;

    @PostMapping("/teacher/{teacherId}/students")
    public ResponseEntity<Void> createStudent(@PathVariable Long teacherId, @RequestBody Student student){
        studentService.addStudent(teacherId, student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/teacher/{teacherId}/students")
    public ResponseEntity<List<Student>> getAllStudentsByTeacherId(@PathVariable Long teacherId){
        return new ResponseEntity<>(studentService.getAllStudentsByTeacherId(teacherId), HttpStatus.OK);

    }

    @PutMapping("/teacher/{teacherId}/students/{studentId}")
    public ResponseEntity<Void> updateStudent(@PathVariable Long teacherId, @PathVariable Long studentId, @RequestBody Student student){
        studentService.updateStudent(teacherId, studentId, student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Optional<Student>> removeStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
