package com.example.demo.services;

import com.example.demo.models.dtos.RentalDto;
import com.example.demo.models.entities.Customer;
import com.example.demo.models.entities.Movie;
import com.example.demo.models.entities.Rental;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.MovieRepository;
import com.example.demo.repositories.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;
    private final MovieRepository movieRepository;
    private final CustomerRepository customerRepository;

    public RentalService(RentalRepository rentalRepository,
                         MovieRepository movieRepository,
                         CustomerRepository customerRepository) {
        this.rentalRepository = rentalRepository;
        this.movieRepository = movieRepository;
        this.customerRepository = customerRepository;
    }

    public RentalDto save(RentalDto dto) {

        Movie movie = movieRepository.findById(dto.getMovieId())
                .orElseThrow(NoSuchElementException::new);

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(NoSuchElementException::new);

        Rental rental = new Rental(
                dto.getId(),
                dto.getRentalDate(),
                dto.getReturnDate(),
                movie,
                customer
        );

        return toDto(rentalRepository.save(rental));
    }

    public List<RentalDto> findAll() {
        return rentalRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public RentalDto findById(Integer id) {
        return toDto(
                rentalRepository.findById(id)
                        .orElseThrow(NoSuchElementException::new)
        );
    }

    public RentalDto edit(RentalDto dto) {

        Movie movie = movieRepository.findById(dto.getMovieId())
                .orElseThrow(NoSuchElementException::new);

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(NoSuchElementException::new);

        Rental rental = new Rental(
                dto.getId(),
                dto.getRentalDate(),
                dto.getReturnDate(),
                movie,
                customer
        );

        return toDto(rentalRepository.save(rental));
    }

    public void delete(Integer id) {
        rentalRepository.deleteById(id);
    }

    private RentalDto toDto(Rental rental) {
        return new RentalDto(
                rental.getId(),
                rental.getRentalDate(),
                rental.getReturnDate(),
                rental.getMovie().getId(),
                rental.getCustomer().getId()
        );
    }
}