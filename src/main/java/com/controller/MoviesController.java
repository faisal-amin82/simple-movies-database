package com.controller;

import com.model.movies.Movies;
import com.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/simple-movies-db", produces = MediaType.APPLICATION_JSON_VALUE)
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping(path = "/getAllMovies")
    public Movies getAll() {

        return moviesService.getAllMovies();
    }
}
