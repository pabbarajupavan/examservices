package com.quest.examservices.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId ;

    private String userName ;
    private String password ;
    private String email ;
    private String role ;
    private Long contact ;
    private Timestamp creationTime ;
    private Timestamp lastUpdateDate ;
    private String createdBy ;
    private String lastUpdatedBy ;
    
}
