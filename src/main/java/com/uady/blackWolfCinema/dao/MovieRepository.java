package com.uady.blackWolfCinema.dao;

import com.uady.blackWolfCinema.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    public List<Movie> findAllByOrderByMovieNameAsc();
}
