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
@Table(name = "teachers_table",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Teacher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId ;

    private String firstName ;
    private String lastName ;
    private String allotedClass ;
    private String allotedSection ;
    private String subject ;
    private Timestamp creationTime ;
    private Timestamp lastUpdateDate ;
    private String createdBy ;
    private String lastUpdatedBy ;
    @Column(unique = true)
    private String email ;
}
