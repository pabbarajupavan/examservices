package com.quest.examservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quest.examservices.model.Student;


@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student,Long>{

    //List<StudentAccessResponse> save(StudentAccessRequest request);
    
}
