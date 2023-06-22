package com.quest.examservices.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "students_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId ;

    private String firstName ;
    private String lastName ;
    @Column(name = "roll_number",unique = true)
    private String rollNumber ;
    private String studentClass ;
    private String studentSection ;
    private Timestamp creationTime ;
    private Timestamp lastUpdateDate ;
    private String createdBy ;
    private String lastUpdatedBy ;
    private String email ;
    
}
