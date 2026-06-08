package com.example.demo.controllers;

import com.example.demo.models.dtos.RentalDto;
import com.example.demo.services.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService service;

    public RentalController(RentalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RentalDto> save(@RequestBody RentalDto rentalDto) {
        return ResponseEntity.ok(service.save(rentalDto));
    }

    @GetMapping
    public ResponseEntity<List<RentalDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<RentalDto> edit(@RequestBody RentalDto rentalDto) {
        return ResponseEntity.ok(service.edit(rentalDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}