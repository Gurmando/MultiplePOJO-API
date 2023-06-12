package com.Gman.Teacher.Repository;

import com.Gman.Teacher.Models.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher, Long> {

    Teacher findByName(String name);

}
