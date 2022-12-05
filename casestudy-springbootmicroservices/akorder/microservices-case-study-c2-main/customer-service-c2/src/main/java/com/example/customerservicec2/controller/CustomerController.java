package com.example.customerservicec2.controller;

import com.example.customerservicec2.entity.Customer;
import com.example.customerservicec2.repository.CustomerRepository;
import com.example.customerservicec2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;


    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer cst) { return customerService.saveCustomer(cst); }

    @GetMapping("/{id}")
    public Optional<Customer> findCstById(@PathVariable("id") Long cstId) {
        return customerService.findByCstId(cstId);}

    @PutMapping("/update_customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer)
    {

        Optional<Customer> CustomerData = customerRepository.findById(id);
        if (CustomerData.isPresent()) {
            Customer _customer = CustomerData.get();
            _customer.setCustomer_name(customer.getCustomer_name());
            _customer.setCustomer_email(customer.getCustomer_email());
            _customer.setCustomer_phone(customer.getCustomer_phone());
            _customer.setCustomer_city(customer.getCustomer_city());
            _customer.setCustomer_state(customer.getCustomer_state());
            _customer.setCustomer_country(customer.getCustomer_country());

            return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete_customers/{id}")
    public ResponseEntity<HttpStatus> deleteCustomers(@PathVariable("id") long id){
        try {
            customerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception ex) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

