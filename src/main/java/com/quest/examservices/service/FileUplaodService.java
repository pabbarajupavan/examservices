package com.quest.examservices.service;

import java.io.FileNotFoundException;





public interface FileUplaodService {

    public String readDataFromFileAndSaveToDB(String filePath,String userName) throws FileNotFoundException;

    
    
}
