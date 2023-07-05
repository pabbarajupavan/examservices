package com.quest.examservices.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import com.quest.examservices.model.Options;
import com.quest.examservices.model.Question;

public class WordFileParser {

    //method to parse word file.
    public List<Question> parseWordFile(String filePath, String examCode, String userName) throws FileNotFoundException, IOException{
        List<Question> questions = new ArrayList<>() ;
        
        try(FileInputStream fis = new FileInputStream(filePath);
            XWPFDocument document =  new XWPFDocument(fis)){
                List<XWPFParagraph> paragraphs = document.getParagraphs() ;
                Question question = null ;

                for (XWPFParagraph paragraph : paragraphs) {
                    String text = paragraph.getText().trim() ;

                    //to identify question headers
                    if (isQuestionHeader(text)) {
                        question = new Question();
                        question.setText(text);
                        question.setExamCode(examCode);
                        question.setOptions(new ArrayList<>());
                        questions.add(question);
                    }

                    //to identify options
                    else if (question != null){
                        Options opt = new Options();
                        
                        opt.setText(text);
                        question.getOptions().add(opt);
                    } 
                }

            }

            return questions ;
    }

    private boolean isOptionsHeader(String text) {
        return text.contains("answer");
    }

    private boolean isQuestionHeader(String text) {

        //logic to identify question header.
        //here question header is Q:
        return text.startsWith("Q");
    }
    
}
