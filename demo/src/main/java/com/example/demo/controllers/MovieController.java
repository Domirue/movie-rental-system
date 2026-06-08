package com.example.demo.controllers;

import com.example.demo.models.dtos.MovieDto;
import com.example.demo.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MovieDto> save(@RequestBody MovieDto movieDto) {
        return ResponseEntity.ok(service.save(movieDto));
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<MovieDto> edit(@RequestBody MovieDto movieDto) {
        return ResponseEntity.ok(service.edit(movieDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}