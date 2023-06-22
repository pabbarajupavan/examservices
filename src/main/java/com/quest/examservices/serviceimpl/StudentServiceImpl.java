package com.quest.examservices.serviceimpl;

import java.sql.Timestamp;import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.examservices.model.Student;
import com.quest.examservices.pojo.StudentAccessRequest;
import com.quest.examservices.pojo.StudentAccessRequests;
import com.quest.examservices.pojo.StudentAccessResponse;
import com.quest.examservices.repository.StudentRepository;
import com.quest.examservices.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository ;

    private List<StudentAccessResponse> responseList = null;
    private StudentAccessResponse response ;

    @Override
    public List<StudentAccessResponse> saveStudent(StudentAccessRequests requests) {
        // TODO Auto-generated method stub
        responseList = new ArrayList<>() ;
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
                if (student != null) {
                    response.setFirstName(student.getFirstName());
                    response.setLastName(student.getLastName());
                    response.setRollNumber(student.getRollNumber());
                    response.setStudentClass(student.getStudentClass());
                    response.setStudentSection(student.getStudentSection());
                    response.setMessage("SUCCESS");
                    responseList.add(response) ;
                } 
            }
            return responseList ;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            response.setMessage("Failed to create student");
            responseList.add(response) ;
            return responseList ;
        }
        
    }
    
}
