package com.uady.blackWolfCinema.controller;

import com.uady.blackWolfCinema.model.CinemaRoom;
import com.uady.blackWolfCinema.model.Movie;
import com.uady.blackWolfCinema.model.Show;
import com.uady.blackWolfCinema.service.CinemaRoomService;
import com.uady.blackWolfCinema.service.MovieService;
import com.uady.blackWolfCinema.service.ShowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shows")
public class ShowController {
    private ShowService showService;
    private MovieService movieService;
    private CinemaRoomService cinemaRoomService;

    public ShowController(ShowService theShowService, MovieService theMovieService,CinemaRoomService theCinemaRoomService){
        cinemaRoomService=theCinemaRoomService;
        movieService=theMovieService;
        showService=theShowService;
    }

    //Agregar mapping para "list"
    @GetMapping("/list")
    public String listShows(Model theModel){
        //obtener los shows desde la base de datis
        List<Show> theShows= showService.findAll();
        //Agregar al modelo Spring
        theModel.addAttribute("shows", theShows);
        //Retornamos a la hoja html con el contenido
        return "shows/list-shows";
    }

    @GetMapping("/showFormForAddShow")
    public String showFormForAddShow(Model theModel){
        //Creamos nuevo show
        Show theShow= new Show();
        //Agregar a traves del modelo de Spring
        theModel.addAttribute("show", theShow);
        List<Movie> movies = movieService.findAll();
        theModel.addAttribute("movies", movies);
        List<CinemaRoom> cinemaRooms=cinemaRoomService.findAll();
        theModel.addAttribute("cinemaRooms", cinemaRooms);

        return "shows/show-form";
    }
    @GetMapping("/showFormForUpdateShow")
    public String showFormForUpdateShow(@RequestParam("showId")int theId, Model theModel){
        //Se obtiene el show del servicio
        Show theShow= showService.findById(theId);
        //Agregamos el show al modelo para rellenar el formulario
        theModel.addAttribute("show",theShow);
        return "shows/show-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("showId")int theId, Model theModel){
        showService.deleteById(theId);
        return "redirect:/shows/list";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("show") Show theShow,
                       @RequestParam("cinemaRooms") int cinemaRoomId,
                       @RequestParam("movies")int idmovie ) {
        CinemaRoom cinemaRoom = cinemaRoomService.findById(cinemaRoomId);
        Movie movie=movieService.findById(idmovie);
        theShow.setMovie(movie);
        theShow.setCinemaRoom(cinemaRoom);
        showService.save(theShow);
        return "redirect:/shows/list";
    }
/*
    @PostMapping("/save")
    public String save(@ModelAttribute("show")Show theShow){
        showService.save(theShow);
        return "redirect:/shows/list";
    }
    */
}
