package com.uady.blackWolfCinema.controller;
import com.uady.blackWolfCinema.model.Movie;
import com.uady.blackWolfCinema.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService theMovieService){
        movieService=theMovieService;
    }
    //Agregar mapping para "list"
    @GetMapping("/list")
    public String listMovies(Model theModel){
        //obtener peliculas desde la base de datos
        List<Movie> theMovies= movieService.findAll();

        //agregarlo al modelo Spring
        theModel.addAttribute("movies", theMovies);
        System.out.println(theMovies);

        //Retorno la hoja html que contiene mi CRUD con todas las peliculas listadas
        return "movies/list-movies";
    }

    //Se muestra el formulario para agregar una nueva pelicula, se regresa el html que contiene la vista deseada.
    @GetMapping("/showFormForAddMovie")
    public String showFormForAddMovie(Model theModel){
        Movie theMovie= new Movie();
        theModel.addAttribute("movie",theMovie);

        return "movies/movie-form";
    }
    @GetMapping("/showFormForUpdateMovie")
    public String showFormForUpdateMovie(@RequestParam("movieId")int theId, Model theModel){
        //Se obtiene la pelicula del servicio
        Movie theMovie= movieService.findById(theId);
        //Ponemos la pelicula en el modelo para que el formulario se llene con sus datos
        theModel.addAttribute("movie", theMovie);

        return "movies/movie-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("movieId")int theId){
        //Elimina la pelicula
        movieService.deleteById(theId);
        //redirigimos a la pagina donde se listan las peliculas para evitar errores
        return "redirect:/movies/list";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("movie")Movie theMovie){
        movieService.save(theMovie);

        return "redirect:/movies/list";
    }
}
