package com.quest.examservices.pojo;

import lombok.Data;

@Data
public class StudentAccessRequest {
    
    private String firstName ;
    private String lastName ;
    private String email ;
    private String studentClass ;
    private String studentSection ;
    private String rollNumber ;

}
