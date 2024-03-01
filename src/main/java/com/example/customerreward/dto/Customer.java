package com.example.customerreward.dto;

import com.example.customerreward.entity.CustomerEntity;

public class Customer {
    private Long id;
    private String name;

    public Customer() {
    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Does this practice(using constructor to convert dto and entity) reasonable?
    public Customer(CustomerEntity customerEntity){
        this.id = customerEntity.getId();
        this.name = customerEntity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
