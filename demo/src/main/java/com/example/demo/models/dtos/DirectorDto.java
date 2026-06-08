package com.example.demo.models.dtos;

import com.example.demo.models.entities.Director;

public class DirectorDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer birthYear;

    public DirectorDto(Integer id, String firstName, String lastName, Integer birthYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
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

    public static DirectorDto fromEntity(Director director) {
        return new DirectorDto(
                director.getId(),
                director.getFirstName(),
                director.getLastName(),
                director.getBirthYear()
        );
    }
}