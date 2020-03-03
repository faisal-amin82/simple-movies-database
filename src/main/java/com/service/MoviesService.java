package com.service;

import com.dao.Database;
import com.model.movies.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MoviesService {


    private Database database;

    @Autowired
    public MoviesService(Database database) {
        this.database = database;

        ClassLoader classLoader = getClass().getClassLoader();

            File jsonFile = new File(classLoader.getResource("static/movies.json").getFile());
       database.mapDataToMovies(jsonFile);
    }

    public Movies getAllMovies() {

        return database.getMoviesList();
    }
}
