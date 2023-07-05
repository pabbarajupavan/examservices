package com.quest.examservices.serviceimpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.quest.examservices.model.Exam;
import com.quest.examservices.pojo.ExamCreationRequest;
import com.quest.examservices.repository.ExamRepository;
import com.quest.examservices.service.ExamService;

@Service("examService")
public class ExamServiceImpl implements ExamService{

    @Autowired
    private ExamRepository examRepository ;

    private String response = null;
    private long creationTime =  0;
    private Timestamp creTimestamp ;
    private String userName = null ;

    @Override
    public String saveExam(ExamCreationRequest examRequest) {
        // TODO Auto-generated method stub
        try {
                creationTime = System.currentTimeMillis() ;
                creTimestamp = new Timestamp(creationTime) ;
                userName = examRequest.getReqHdr().getUserName();
                Exam exam = new Exam() ;
                exam.setExamCode(examRequest.getExamCode());
                exam.setSubject(examRequest.getSubject());
                exam.setForClass(examRequest.getForClass());
                exam.setForSection(examRequest.getForSection());
                exam.setExamDate(examRequest.getExamDate());
                exam.setNoOfQuestions(examRequest.getNoOfQuestions());
                exam.setTotalMarks(examRequest.getTotalMarks());
                exam.setCreatedBy(userName);
                exam.setCreationTime(creTimestamp);
                exam.setLastUpdateDate(creTimestamp);
                exam.setLastUpdatedBy(userName);
                exam = examRepository.save(exam) ;
                if (exam != null) {
                    response = "Exam created with examCode "+ examRequest.getExamCode() ;
                } else{
                    response = "Exam creation failed" ;
                }
                return response ;
        } catch (DataIntegrityViolationException e){
            e.printStackTrace();
            response = e.getMostSpecificCause().getMessage() ;
            return response ;
        }
         catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            response = e.getMessage();;
            return response ;
        }


       // return response ;
        
    }
    
}
