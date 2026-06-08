package com.example.demo.models.entities;

import com.example.demo.models.dtos.DirectorDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Director {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private String lastName;
    private Integer birthYear;
    private LocalDate timestamp;

    public Director() {
    }

    public Director(Integer id, String firstName, String lastName, Integer birthYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.timestamp = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public static Director fromDto(DirectorDto directorDto) {
        return new Director(
                directorDto.getId(),
                directorDto.getFirstName(),
                directorDto.getLastName(),
                directorDto.getBirthYear()
        );
    }
}