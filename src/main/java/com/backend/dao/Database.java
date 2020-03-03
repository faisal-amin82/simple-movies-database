package com.backend.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.movies.Movies;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class Database {

    private Movies moviesList;

    public Movies getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(Movies moviesList) {
        this.moviesList = moviesList;
    }

    public void mapDataToMovies(File jsonFilePath) {

        try {

            byte[] jsonFile = Files.readAllBytes(jsonFilePath.toPath());

            ObjectMapper mapper = new ObjectMapper();

            moviesList = mapper.readValue(jsonFile, Movies.class);

        } catch (IOException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
        }
    }
}
