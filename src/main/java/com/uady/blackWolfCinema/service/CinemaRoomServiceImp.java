package com.uady.blackWolfCinema.service;
import com.uady.blackWolfCinema.dao.CinemaRoomRepository;
import com.uady.blackWolfCinema.model.CinemaRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CinemaRoomServiceImp implements CinemaRoomService{

    private CinemaRoomRepository cinemaRoomRepository;
    @Autowired
    public CinemaRoomServiceImp(CinemaRoomRepository theCinemaRoomRepository){
        cinemaRoomRepository=theCinemaRoomRepository;
    }

    @Override
    public List<CinemaRoom> findAll() {
        return cinemaRoomRepository.findAll();
    }

    @Override
    public CinemaRoom findById(int theId) {
        Optional<CinemaRoom>result=cinemaRoomRepository.findById(theId);
        CinemaRoom theCinemaRoom=null;
        if(result.isPresent()){
            theCinemaRoom=result.get();
        }else{
            throw new RuntimeException("No se encontro la sala de cine con el id");
        }
        return theCinemaRoom;
    }

    @Override
    public CinemaRoom save(CinemaRoom theCinemaRoom) {
        return cinemaRoomRepository.save(theCinemaRoom);
    }

    @Override
    public void deleteById(int theId) {
        cinemaRoomRepository.deleteById(theId);
    }
}
