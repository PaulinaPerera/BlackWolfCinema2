package com.uady.blackWolfCinema.model;
import jakarta.persistence.*;

@Entity
@Table(name ="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmovie")
    private int idmovie;

    @Column(name="name")
    private String movieName;

    @Column(name="synopsis")
    private String movieSynopsis;
    @Column(name="length")
    private int movieLength;
    @Column(name="trailer_link")
    private String trailerLink;

    public Movie(){

    }

    public Movie(String movieName, String movieSynopsis, String trailerLink, int movieLength){
        this.movieName=movieName;
        this.movieSynopsis=movieSynopsis;
        this.trailerLink=trailerLink;
        this.movieLength=movieLength;

    }

    public int getIdmovie() {
        return idmovie;
    }

    public void setIdmovie(int idmovie) {
        this.idmovie = idmovie;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieSynopsis() {
        return movieSynopsis;
    }

    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }
    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

}
