package com.Gman.Teacher.Service;

import com.Gman.Teacher.Models.Student;
import com.Gman.Teacher.Models.Teacher;
import com.Gman.Teacher.Repository.StudentRepo;
import com.Gman.Teacher.Repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private StudentRepo studentRepo;

    public void addStudent(Long teacherId, Student student){
        Teacher teacher = teacherRepo.findById(teacherId).orElse(null);
        student.setTeacher(teacher);
        studentRepo.save(student);

    }

    public List<Student> getAllStudentsByTeacherId(Long customerId){
        return studentRepo.findAllStudentsByTeacherId(customerId);
    }

    public void updateStudent(Long teacherId, Long studentId, Student student){
        Teacher teacher = teacherRepo.findById(teacherId).orElse(null);
        Student s = studentRepo.findById(studentId).orElse(null);
        if( s != null){
            s.setName(student.getName());
            s.setGrade(student.getGrade());
        }
        student.setTeacher(teacher);
        studentRepo.save(student);

    }

    public void deleteStudent(Long orderId){
        studentRepo.deleteById(orderId);
    }

    public Student getStudentById(Long studentId){
        return studentRepo.findById(studentId).orElse(null);
    }
}
