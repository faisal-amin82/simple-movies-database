package com.service;

import com.backend.dao.Database;
import com.model.movies.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    @Autowired
    private Database database;

    public List<Movies> getAllMovies(String jsonFilePath) {

        database.mapDataToMovies(jsonFilePath);
        return database.getMoviesList();
    }
}
