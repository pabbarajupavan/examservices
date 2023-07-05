package com.quest.examservices.pojo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ExamCreationRequest {
    
    private ReqHdr reqHdr ;
    private String examCode ;
    private String subject ;
    private String forClass ;
    private String forSection ;
    private int noOfQuestions ;
    private int totalMarks ;
    private Timestamp examDate ;
}
