package com.example.demo.models.entities;

import com.example.demo.models.dtos.RentalDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Rental {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate rentalDate;
    private LocalDate returnDate;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Customer customer;

    public Rental() {
    }

    public Rental(Integer id, LocalDate rentalDate, LocalDate returnDate, Movie movie, Customer customer) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.movie = movie;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public Movie getMovie() {
        return movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public static Rental fromDto(RentalDto rentalDto, Movie movie, Customer customer) {
        return new Rental(
                rentalDto.getId(),
                rentalDto.getRentalDate(),
                rentalDto.getReturnDate(),
                movie,
                customer
        );
    }
}