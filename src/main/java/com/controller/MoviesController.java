package com.controller;

import com.model.movies.Movies;
import com.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/simple-movies-db", produces = MediaType.APPLICATION_JSON_VALUE)
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    private static final String PATH = "/Users/famin/MoviesDB/simple-movies-database/src/main/resources/static/movies.json";
    @GetMapping(path = "/getAllMovies")
    public List<Movies> getAll() {


        return moviesService.getAllMovies(PATH);
    }
}
