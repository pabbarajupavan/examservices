package com.quest.examservices.serviceimpl;


import java.sql.Timestamp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.examservices.model.Student;
import com.quest.examservices.pojo.StudentAccessRequest;
import com.quest.examservices.pojo.StudentAccessRequests;
import com.quest.examservices.repository.StudentRepository;
import com.quest.examservices.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository ;

   
    @Override
    public String saveStudent(StudentAccessRequests requests) {
        // TODO Auto-generated method stub
        String  response = null ;
        try {
            long creationTime = System.currentTimeMillis() ;
            Timestamp creTimestamp = new Timestamp(creationTime) ;
            String userName = requests.getReqHdr().getUserName();
            for (StudentAccessRequest request : requests.getStudentList()) {
                Student student = new Student() ;
                student.setFirstName(request.getFirstName());
                student.setLastName(request.getLastName());
                student.setEmail(request.getEmail());
                student.setStudentClass(request.getStudentClass());
                student.setStudentSection(request.getStudentSection());
                student.setRollNumber(request.getRollNumber());
                student.setCreatedBy(userName);
                student.setCreationTime(creTimestamp);
                student.setLastUpdatedBy(userName);
                student.setLastUpdateDate(creTimestamp);
                student = studentRepository.save(student) ;
                System.out.println("student" +student.getFirstName());
                if (student != null) {
                    response = "Student record inserted" ;
                } 
            }
            return response ;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            response = e.getMessage() ;
            return response ;
           
        }
       
        
    }
    
}
