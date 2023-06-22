package com.quest.examservices.service;

import java.util.List;


import com.quest.examservices.pojo.StudentAccessRequests;
import com.quest.examservices.pojo.StudentAccessResponse;

public interface StudentService {

    public List<StudentAccessResponse> saveStudent(StudentAccessRequests studentAccessRequest) ;
    
}
