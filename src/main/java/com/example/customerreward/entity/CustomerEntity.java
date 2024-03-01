package com.example.customerreward.entity;


import com.example.customerreward.dto.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    public CustomerEntity() {
    }

    public CustomerEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Does this practice(using constructor to convert dto and entity) reasonable?
    public CustomerEntity(Customer customer){
        this.id = customer.getId();
        this.name = customer.getName();
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
