package com.quest.examservices.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.examservices.model.Options;
import com.quest.examservices.model.Question;
import com.quest.examservices.parser.WordFileParser;
import com.quest.examservices.repository.OptionRepository;
import com.quest.examservices.repository.QuestionRepository;
import com.quest.examservices.service.QuestionService;

//import jakarta.transaction.Transactional;

@Service("/questionService")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository ;

    @Autowired
    private OptionRepository optionRepository ;

    private String response = null ;

    

    @Override
    public void readQuestionsFromFileAndSaveToDB(String filePath, String userName, String examCode) {
        // TODO Auto-generated method stub
        WordFileParser parser = new WordFileParser() ;
        try {
            List<Question> questions = parser.parseWordFile(filePath, examCode, userName);

            for (Question question : questions) {
                questionRepository.save(question) ;

                for (Options option : question.getOptions()) {
                    option.setQuestion(question);
                    
                    optionRepository.save(option) ;
                }
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    } 

   

   
    

   
    
}
