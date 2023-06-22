package com.quest.examservices.pojo;

import java.util.List;

import lombok.Data;

@Data
public class StudentAccessRequests {

    private ReqHdr reqHdr ;
    private List<StudentAccessRequest> studentList ;

    
}
