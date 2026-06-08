package com.example.demo.controllers;

import com.example.demo.models.dtos.DirectorDto;
import com.example.demo.services.DirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    private final DirectorService service;

    public DirectorController(DirectorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DirectorDto> save(@RequestBody DirectorDto directorDto) {
        return ResponseEntity.ok(service.save(directorDto));
    }

    @GetMapping
    public ResponseEntity<List<DirectorDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<DirectorDto> edit(@RequestBody DirectorDto directorDto) {
        return ResponseEntity.ok(service.edit(directorDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}