package com.example.demo.models.entities;

import com.example.demo.models.dtos.MovieDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;
    private String genre;
    private Integer releaseYear;
    private LocalDate timestamp;

    public Movie() {
    }

    public Movie(Integer id, String title, String genre, Integer releaseYear) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.timestamp = LocalDate.now();
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

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public static Movie fromDto(MovieDto movieDto) {
        return new Movie(
                movieDto.getId(),
                movieDto.getTitle(),
                movieDto.getGenre(),
                movieDto.getReleaseYear()
        );
    }
}