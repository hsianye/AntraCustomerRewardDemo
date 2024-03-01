package com.example.customerreward.controller;


import com.example.customerreward.dto.Customer;
import com.example.customerreward.dto.Reward;
import com.example.customerreward.dto.Transaction;
import com.example.customerreward.exception.CustomerNotFoundException;
import com.example.customerreward.exception.NoTransactionInThreeMonthsException;
import com.example.customerreward.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping("/")
    public String home(){
        return "Hello World";
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        Customer savedCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody Transaction transaction){
        Transaction savedTransaction = customerService.createTransaction(transaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/customer/{customerId}/rewards")
    public ResponseEntity<Reward> getRewards(@PathVariable Long customerId){
        Reward reward = customerService.getRewardsForCustomerInLastThreeMonths(customerId);
        return new ResponseEntity<>(reward, HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Map<String, String>> methodArgumentNotValidHandler(MethodArgumentNotValidException e){
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(
                error -> errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    protected ResponseEntity<Object> handleCustomerNotFound(CustomerNotFoundException e) {
        // Return a 404 status with a custom message
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoTransactionInThreeMonthsException.class)
    protected ResponseEntity<Object> handleTransactionNotFound(NoTransactionInThreeMonthsException e) {
        // Return a 404 status with a custom message
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
    }
}
