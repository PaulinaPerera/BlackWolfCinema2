package com.uady.blackWolfCinema.dao;

import com.uady.blackWolfCinema.model.User;

public interface UserDao {

    void register(User user);
    boolean verifyEmailAndPassword(User user);
}
