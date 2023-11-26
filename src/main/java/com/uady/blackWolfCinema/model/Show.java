package com.uady.blackWolfCinema.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name= "movie_show")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idshow")
    private int showId;

    @Column(name="date")
    private LocalDate showDate;

    @Column(name="hour")
    private LocalTime showHour;


    @ManyToOne
    @JoinColumn(name = "idmovie", referencedColumnName = "idmovie")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "idcinema_room", referencedColumnName = "idcinema_room")
    private CinemaRoom cinemaRoom;

    public Show(){

    }

    public Show(LocalDate showDate, LocalTime showHour, Movie movie, CinemaRoom cinemaRoom) {
        this.showDate = showDate;
        this.showHour = showHour;
        this.movie=movie;
        this.cinemaRoom=cinemaRoom;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getShowHour() {
        return showHour;
    }

    public void setShowHour(LocalTime showHour) {
        this.showHour = showHour;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }
}
