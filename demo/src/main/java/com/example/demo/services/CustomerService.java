package com.example.demo.services;

import com.example.demo.models.dtos.CustomerDto;
import com.example.demo.models.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerDto save(CustomerDto customerDto) {
        return CustomerDto.fromEntity(repository.save(Customer.fromDto(customerDto)));
    }

    public List<CustomerDto> findAll() {
        return repository.findAll()
                .stream()
                .map(CustomerDto::fromEntity)
                .collect(Collectors.toList());
    }

    public CustomerDto findById(Integer id) {
        return CustomerDto.fromEntity(
                repository.findById(id).orElseThrow(NoSuchElementException::new)
        );
    }

    public CustomerDto edit(CustomerDto customerDto) {
        return CustomerDto.fromEntity(repository.save(Customer.fromDto(customerDto)));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}