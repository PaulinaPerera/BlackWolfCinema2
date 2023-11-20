package com.uady.blackWolfCinema.service;

import com.uady.blackWolfCinema.dao.CinemaRoomDao;
import com.uady.blackWolfCinema.model.CinemaRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaRoomServiceImp implements CinemaRoomService{
    private CinemaRoomDao cinemaRoomDao;

    @Autowired
    public CinemaRoomServiceImp(CinemaRoomDao cinemaRoomDao){
        this.cinemaRoomDao= cinemaRoomDao;
    }
    @Override
    public CinemaRoom findRoomById(int theCinemaRoomID) {
        return cinemaRoomDao.getRoomById(theCinemaRoomID);
    }
}
