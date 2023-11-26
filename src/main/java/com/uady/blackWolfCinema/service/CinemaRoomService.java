package com.uady.blackWolfCinema.service;

import com.uady.blackWolfCinema.model.CinemaRoom;

import java.util.List;

public interface CinemaRoomService {
    List<CinemaRoom> findAll();
    CinemaRoom findById(int theId);
    CinemaRoom save(CinemaRoom theCinemaRoom);
    void deleteById(int theId);
}
