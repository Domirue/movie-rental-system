package com.example.demo.models.dtos;

import com.example.demo.models.entities.Movie;

public class MovieDto {

    private Integer id;
    private String title;
    private String genre;
    private Integer releaseYear;

    public MovieDto(Integer id, String title, String genre, Integer releaseYear) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public static MovieDto fromEntity(Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getGenre(),
                movie.getReleaseYear()
        );
    }
}