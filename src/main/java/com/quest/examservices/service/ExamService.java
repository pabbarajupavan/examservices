package com.quest.examservices.service;

import com.quest.examservices.pojo.ExamCreationRequest;


public interface ExamService {

    String saveExam(ExamCreationRequest examRequest);
    
}
