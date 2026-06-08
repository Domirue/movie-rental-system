package com.example.demo.models.dtos;

import com.example.demo.models.entities.Customer;

public class CustomerDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    public CustomerDto(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public static CustomerDto fromEntity(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail()
        );
    }
}