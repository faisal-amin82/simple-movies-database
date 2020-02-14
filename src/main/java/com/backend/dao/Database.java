package com.backend.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.movies.Movies;
import com.utilities.FileReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Database {

    private List<Movies> moviesList = new ArrayList<>();

    public List<Movies> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(List<Movies> moviesList) {
        this.moviesList = moviesList;
    }

    public void mapDataToMovies(String jsonFilePath) {

        try {
            byte[] jsonFile = FileReader.readJsonFile(jsonFilePath);

            ObjectMapper mapper = new ObjectMapper();
            Movies movies = mapper.readValue(jsonFile, Movies.class);

            moviesList.add(movies);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
