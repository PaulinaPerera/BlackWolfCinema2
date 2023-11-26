package com.uady.blackWolfCinema.service;

import com.uady.blackWolfCinema.model.Movie;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface MovieService {

    List<Movie> findAll();
    Movie findById(int theId);
    Movie save(Movie theMovie);

    void deleteById(int theId);
}
