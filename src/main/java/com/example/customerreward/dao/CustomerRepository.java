package com.example.customerreward.dao;


import com.example.customerreward.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
