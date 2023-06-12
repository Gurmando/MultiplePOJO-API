package com.Gman.Teacher.Repository;

import com.Gman.Teacher.Models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

    List<Student> findAllStudentsByTeacherId(Long studentId);
}
