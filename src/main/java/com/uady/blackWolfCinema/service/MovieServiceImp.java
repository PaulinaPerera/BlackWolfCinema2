package com.uady.blackWolfCinema.service;
import com.uady.blackWolfCinema.dao.MovieRepository;
import com.uady.blackWolfCinema.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImp implements MovieService{

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImp(MovieRepository theMovieRepository){
        movieRepository=theMovieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAllByOrderByMovieNameAsc();
    }

    @Override
    public Movie findById(int theId) {
        Optional<Movie> result = movieRepository.findById(theId);
        Movie theMovie = null;
        if (result.isPresent()) {
            theMovie = result.get();
        } else {
            throw new RuntimeException("No se encontro la pelicula con el id: " + theId);
        }
        return theMovie;
    }
    @Override
    public Movie save(Movie theMovie) {
        return movieRepository.save(theMovie);
    }

    @Override
    public void deleteById(int theId) {
        movieRepository.deleteById(theId);

    }
}
