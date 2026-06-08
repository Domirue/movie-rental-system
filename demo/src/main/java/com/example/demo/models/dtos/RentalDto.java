package com.example.demo.models.dtos;

import java.time.LocalDate;

public class RentalDto {

    private Integer id;
    private LocalDate rentalDate;
    private LocalDate returnDate;

    private Integer movieId;
    private Integer customerId;

    public RentalDto(Integer id, LocalDate rentalDate, LocalDate returnDate, Integer movieId, Integer customerId) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.movieId = movieId;
        this.customerId = customerId;
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

    public Integer getMovieId() {
        return movieId;
    }

    public Integer getCustomerId() {
        return customerId;
    }
}
