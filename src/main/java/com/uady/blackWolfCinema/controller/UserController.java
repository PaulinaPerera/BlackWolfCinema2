package com.uady.blackWolfCinema.controller;

import com.uady.blackWolfCinema.dao.UserDao;
import com.uady.blackWolfCinema.model.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/users")
public class UserController {
    @Autowired
    private UserDao userDao;

    @PostMapping
    public void registerUser(@RequestBody User user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hashPassword = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hashPassword);
        userDao.register(user);
    }


}

