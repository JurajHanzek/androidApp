package com.example.myapplication.model;

public class MovieRating {

    private Long idMovie;
    private Double rating;
    private Double imdbRating;
    private Double metacriticRating;
    private Double rottenRating;
    public Long getIdMovie() {
        return idMovie;
    }
    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public Double getImdbRating() {
        return imdbRating;
    }
    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }
    public Double getMetacriticRating() {
        return metacriticRating;
    }
    public void setMetacriticRating(Double metacriticRating) {
        this.metacriticRating = metacriticRating;
    }
    public Double getRottenRating() {
        return rottenRating;
    }
    public void setRottenRating(Double rottenRating) {
        this.rottenRating = rottenRating;
    }


}
