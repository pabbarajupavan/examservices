package com.quest.examservices.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.quest.examservices.pojo.ExamCreationRequest;
import com.quest.examservices.pojo.StudentAccessRequests;
import com.quest.examservices.service.ExamService;
import com.quest.examservices.service.FileUplaodService;
import com.quest.examservices.service.QuestionService;
import com.quest.examservices.service.StudentService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/api/admin")
@RestController
@Slf4j
public class AdminController {

    @Autowired
    private StudentService studentService ;

    @Autowired
    private FileUplaodService fileUplaodService ;

    @Autowired
    private ExamService examService ;

    @Autowired
    private QuestionService questionService ;

    String response = null;
    
    @PostMapping(value = "/addStudents",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addStudents(@RequestBody StudentAccessRequests studentAccessRequest){

        response = studentService.saveStudent(studentAccessRequest) ;
        return response ;
    }

    //file upload endpoint
    @PostMapping("/uploadFile")
    public String fileUpload(@RequestParam("file") MultipartFile file,@RequestParam("fileName") String fileName, @RequestParam("userName") String userName) {

        
        if (!file.isEmpty()) {
            try {
               //to save the upload file locally 
               String filePath = saveFileLocally(file) ;
               //if file name contains students
               
               if (!fileName.isBlank() && fileName.length() > 0 && fileName.contains("students")) {
                response = fileUplaodService.readDataFromFileAndSaveToDB(filePath,userName) ;
                return response;
               } 
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                response = e.getMessage() ;
                return response ;
            }
        } else{
            response = "File is empty";
        }
        return response;
        
    }

    private String saveFileLocally(MultipartFile file) throws IOException{
        Path path = Paths.get(file.getOriginalFilename());
        Files.write(path, file.getBytes()) ;
        return path.toAbsolutePath().toString() ;
        
    }


    /**
     * rest call to create exam
     * exam request
     */
    @PostMapping("/createExam")
    public String createExam(@RequestBody ExamCreationRequest examRequest) {
        response = examService.saveExam(examRequest) ;
        return response;
    }

    @PostMapping("/uploadQuestions")
    public String updloadQuestionsFromFile(@RequestParam("file") MultipartFile file,@RequestParam("examCode") String examCode, @RequestParam("userName") String userName) {
        log.info("inside upload questions method" ) ;
        if (!file.isEmpty()) {
            try {
               //to save the upload file locally 
               String filePath = saveFileLocally(file) ;
               //if file name contains students
               
               questionService.readQuestionsFromFileAndSaveToDB(filePath, userName, examCode) ;
               return "";
                
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                response = e.getMessage() ;
                return response ;
            }
        } else{
            response = "File is empty";
        }
        return response;
    }
    
    
}
