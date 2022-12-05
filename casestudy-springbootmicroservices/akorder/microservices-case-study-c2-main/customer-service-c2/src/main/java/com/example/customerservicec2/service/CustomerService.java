package com.example.customerservicec2.service;

import com.example.customerservicec2.entity.Customer;
import com.example.customerservicec2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer saveCustomer(Customer cst) {
        return customerRepository.save(cst);}

    public Optional<Customer> findByCstId(Long cstId) {
        return customerRepository.findById(cstId);
    }
}
