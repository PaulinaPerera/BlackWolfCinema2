package com.uady.blackWolfCinema.dao;

import com.uady.blackWolfCinema.model.Movie;
import com.uady.blackWolfCinema.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
