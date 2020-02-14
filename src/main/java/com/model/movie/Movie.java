package com.model.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.model.comments.Comments;

import java.util.List;

public class Movie {

    @JsonProperty("movie_id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("available_in_3d")
    private String availableIn3d;

    @JsonProperty("age_rating")
    private String ageRating;

    @JsonProperty("likes")
    private long likes;

    @JsonProperty("comments")
    private List<Comments> comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getAvailableIn3d() {
        return availableIn3d;
    }

    public void setAvailableIn3d(String availableIn3d) {
        this.availableIn3d = availableIn3d;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
}
