package com.uady.blackWolfCinema.controller;

import com.uady.blackWolfCinema.model.CinemaRoom;
import com.uady.blackWolfCinema.service.CinemaRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CinemaRoomController {

    private CinemaRoomService cinemaRoomService;
    //Inject cinema room dao
    @Autowired
    public CinemaRoomController(CinemaRoomService theCinemaRoomService){
        cinemaRoomService =theCinemaRoomService;
    }
    @GetMapping("/cinemaRoom/{cinemaRoomID}")
    public CinemaRoom getCinemaRoom(@PathVariable int cinemaRoomID){
        CinemaRoom theCinemaRoom = cinemaRoomService.findById(cinemaRoomID);

        if(theCinemaRoom ==null){
            throw new RuntimeException("The ID: "+ cinemaRoomID +" does not exist");
        }
        return theCinemaRoom;
    }

}
