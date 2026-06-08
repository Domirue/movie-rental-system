package com.example.demo.services;

import com.example.demo.models.dtos.DirectorDto;
import com.example.demo.models.entities.Director;
import com.example.demo.repositories.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class DirectorService {

    private final DirectorRepository repository;

    public DirectorService(DirectorRepository repository) {
        this.repository = repository;
    }

    public DirectorDto save(DirectorDto directorDto) {
        return DirectorDto.fromEntity(repository.save(Director.fromDto(directorDto)));
    }

    public List<DirectorDto> findAll() {
        return repository.findAll()
                .stream()
                .map(DirectorDto::fromEntity)
                .collect(Collectors.toList());
    }

    public DirectorDto findById(Integer id) {
        return DirectorDto.fromEntity(
                repository.findById(id).orElseThrow(NoSuchElementException::new)
        );
    }

    public DirectorDto edit(DirectorDto directorDto) {
        return DirectorDto.fromEntity(repository.save(Director.fromDto(directorDto)));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}