package com.quest.examservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quest.examservices.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long>{
    
}
