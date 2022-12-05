package com.example.customerms.repository;

import com.example.customerms.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepostiory extends JpaRepository<Customer, Long> {
    Customer findByCustId(Long id);
}
