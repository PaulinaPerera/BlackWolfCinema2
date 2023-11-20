package com.uady.blackWolfCinema.dao;

import com.uady.blackWolfCinema.model.CinemaRoom;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaRoomDaoImp implements CinemaRoomDao{

    private EntityManager entityManager;

    @Autowired
    public CinemaRoomDaoImp(EntityManager entityManager){
        this.entityManager= entityManager;
    }
    @Override
    public CinemaRoom getRoomById(int cinemaRoomId) {
        CinemaRoom theCinemaRoom = entityManager.find(CinemaRoom.class, cinemaRoomId);
        return theCinemaRoom;
    }
}
