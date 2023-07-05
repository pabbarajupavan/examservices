package com.quest.examservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quest.examservices.model.Exam;

@Repository("examRepository")
public interface ExamRepository extends JpaRepository<Exam,Long> {
    
}
