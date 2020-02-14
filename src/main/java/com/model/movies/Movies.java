package com.model.movies;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.model.comments.Comments;
import com.model.movie.Movie;

import java.util.List;

public class Movies {

    @JsonProperty("movies")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
