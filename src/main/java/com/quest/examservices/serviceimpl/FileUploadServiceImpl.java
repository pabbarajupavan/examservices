package com.quest.examservices.serviceimpl;

import java.io.BufferedReader;

import java.io.FileReader;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.quest.examservices.model.Student;

import com.quest.examservices.repository.StudentRepository;
import com.quest.examservices.service.FileUplaodService;



@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUplaodService{

    @Autowired
    private StudentRepository studentRepository ;

    @Override
    public String readDataFromFileAndSaveToDB(String filePath, String userName)  {
        // TODO Auto-generated method stub
        String resp = null;
        
        long creationTime = System.currentTimeMillis() ;
        Timestamp creTimestamp = new Timestamp(creationTime) ;
       try (Stream<String> lines = new BufferedReader(new FileReader(filePath)).lines()){
            List<Student> studentList = lines
                .skip(1) //skips the header line
                .map(line -> line.split(","))
                .map(columns -> {
                    Student studnet = new Student();
                    studnet.setFirstName(columns[0]);
                    studnet.setLastName(columns[1]);
                    studnet.setEmail(columns[2]);
                    studnet.setRollNumber(columns[3]);
                    studnet.setStudentClass(columns[4]);
                    studnet.setStudentSection(columns[5]);
                    studnet.setCreatedBy(userName);
                    studnet.setCreatedBy(userName);
                    studnet.setCreationTime(creTimestamp);
                    studnet.setLastUpdatedBy(userName);
                    studnet.setLastUpdateDate(creTimestamp);
                    return studnet ;
                }).collect(Collectors.toList());

                try {
                  List<Student> students = studentRepository.saveAll(studentList) ;
                if (students!= null && students.size() !=0) {
                   resp = "Student list added to the database" ; 
                }
                return resp ;  
                } catch (DataIntegrityViolationException e) {
                    // TODO: handle exception
                    //e.printStackTrace();
                    resp = e.getMostSpecificCause().getMessage();
                    return resp;
                }
                
        
       } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
        resp = e.getMessage() ;
        return resp ;
       } 
        
    }
    
}
