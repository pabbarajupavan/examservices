package com.quest.examservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.quest.examservices.pojo.StudentAccessRequests;

import com.quest.examservices.service.StudentService;

@RequestMapping("/api/admin")
@RestController
public class AdminController {

    @Autowired
    private StudentService studentService ;

    
    
    @RequestMapping(value = "/addStudents", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addStudents(@RequestBody StudentAccessRequests studentAccessRequest){

        String response = studentService.saveStudent(studentAccessRequest) ;
        return response ;
    }

}
