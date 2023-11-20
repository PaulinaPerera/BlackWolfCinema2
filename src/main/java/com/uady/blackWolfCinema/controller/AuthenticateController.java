package com.uady.blackWolfCinema.controller;

import com.uady.blackWolfCinema.dao.UserDao;
import com.uady.blackWolfCinema.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value= "api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user){
        String response="Fail";
        if(userDao.verifyEmailAndPassword(user)){
            response= "Ok";
        }
        return response;
    }
}
