package com.quest.examservices.service;

public interface QuestionService {
    
   
    public void readQuestionsFromFileAndSaveToDB(String filePath, String userName, String examCode) ;
}
