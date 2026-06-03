package com.crud.project.StudentRepo;

import com.crud.project.model.Student;
import com.crud.project.model.classEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findByFirstNameContainingIgnoreCase(String firstName);

    @Query("select count(*) from Student")
    int countStudentAll();


    List<Student> findByClassName(classEnum className);

    @Query("select count(distinct s.className) from Student s")
    int CountDistinctClass();
}
