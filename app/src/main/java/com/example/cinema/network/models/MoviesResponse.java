package com.example.cinema.network.models;import com.google.gson.annotations.SerializedName;

public class MoviesResponse {
    @SerializedName("movieId")
    private Integer movieId;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("poster")
    private String image;

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}