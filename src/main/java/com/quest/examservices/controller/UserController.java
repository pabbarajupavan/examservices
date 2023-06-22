package com.quest.examservices.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quest.examservices.pojo.CreateUserRequest;
import com.quest.examservices.pojo.UserSetupResponse;

@RestController
@RequestMapping("/api")
public class UserController {

    @RequestMapping(value = "/userSetup", method = RequestMethod.POST)
    public @ResponseBody UserSetupResponse createUser(@RequestBody CreateUserRequest request){
        return null;
    }


    
}
