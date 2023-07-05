package com.quest.examservices.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "exams_table",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"exam_code"})})
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "exam_code", unique = true)
    private String examCode ;
    private String subject ;
    private String forClass ;
    private String forSection ;
    private int noOfQuestions ;
    private int totalMarks ;
    private Timestamp examDate ;
    private Timestamp creationTime ;
    private Timestamp lastUpdateDate ;
    private String createdBy ;
    private String lastUpdatedBy ;
    
}
