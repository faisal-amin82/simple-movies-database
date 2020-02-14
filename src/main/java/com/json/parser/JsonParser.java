package com.json.parser;

import com.backend.dao.Database;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.utilities.FileReader;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static void main(String args[]) {

        Database database = new Database();

        database.mapDataToMovies("/Users/famin/MoviesDB/simple-movies-database/src/main/resources/static/movies.json");

        System.out.println(database.getMoviesList().get(0).getMovies().get(0).getComments().get(0).getMessage());

    }

    public static List<String> getNextObject(String content) {

        List<String> tokenizedList = new ArrayList<>();

        StringBuilder object = null;

        int nextCharIndex = 0;

        char nextChar = ' ';

        int contentLength = content.length();

        while ( nextCharIndex < contentLength) {

            nextChar = content.charAt(nextCharIndex);
             if(nextChar == '{') {

                 object = new StringBuilder();
                 object.append(nextChar);

                while (++nextCharIndex < content.length()) {

                    nextChar = content.charAt(nextCharIndex);
                    object.append(nextChar);

                    if(nextChar == '}') {
                        break;
                    }
                    else if (nextChar == '{' || nextChar == '[') {
                        throw new IllegalArgumentException("Not a valid JSON Object");
                    }
                }

                if(validateJsonObject(object.toString()))
                        tokenizedList.add(object.toString());
            }
            nextCharIndex++;
        }

        return tokenizedList;
    }

    public static boolean validateJsonObject(String jsonObject) {

        if (jsonObject.contains(",,")) {
            return false;
        }

        for (int i = 0; i < jsonObject.length(); i++) {

            if(jsonObject.charAt(i) == '{') {

                int nextCharIndex = i;

                while(++nextCharIndex < jsonObject.length()) {

                    if(jsonObject.charAt(nextCharIndex) == '}') {
                        return true;
                    }

                    else if(jsonObject.charAt(nextCharIndex) == '{') {
                        return false;
                    }
                }

                if(jsonObject.charAt(jsonObject.length() - 1) != '}') {
                    return false;
                }
            }
        }

        return true;    // Assume all is well
    }
}
