package com.example.customerreward.dto;

import com.example.customerreward.entity.TransactionEntity;
import com.example.customerreward.utils.ConversionUtil;

import java.time.LocalDateTime;

public class Transaction {
    private Long id;
    private Customer customer;
    private LocalDateTime datetime;
    private Long amount;

    public Transaction() {
    }

    public Transaction(Long id, Customer customer, LocalDateTime datetime, Long amount) {
        this.id = id;
        this.customer = customer;
        this.datetime = datetime;
        this.amount = amount;
    }

    // Does this practice(using constructor to convert dto and entity) reasonable?
    public Transaction(TransactionEntity transactionEntity){
        this.id = transactionEntity.getId();
        this.customer = ConversionUtil.toCustomerDto(transactionEntity.getCustomer());
        this.datetime = transactionEntity.getDatetime();
        this.amount = transactionEntity.getAmount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
