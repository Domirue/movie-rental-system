package com.example.demo.services;

import com.example.demo.models.dtos.MovieDto;
import com.example.demo.models.entities.Movie;
import com.example.demo.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public MovieDto save(MovieDto movieDto) {
        return MovieDto.fromEntity(repository.save(Movie.fromDto(movieDto)));
    }

    public List<MovieDto> findAll() {
        return repository.findAll()
                .stream()
                .map(MovieDto::fromEntity)
                .collect(Collectors.toList());
    }

    public MovieDto findById(Integer id) {
        return MovieDto.fromEntity(
                repository.findById(id).orElseThrow(NoSuchElementException::new)
        );
    }

    public MovieDto edit(MovieDto movieDto) {
        return MovieDto.fromEntity(repository.save(Movie.fromDto(movieDto)));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}