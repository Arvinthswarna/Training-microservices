package com.example.customerms.service;

import com.example.customerms.entity.Customer;
import com.example.customerms.repository.CustomerRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepostiory customerRepostiory;

    public Customer saveCustomer(Customer customer) {
        return customerRepostiory.save(customer);
    }

    public Customer findCustomerById(Long id) {
        return customerRepostiory.findByCustId(id);
    }
}
