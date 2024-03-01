package com.example.customerreward.dto;

import com.example.customerreward.entity.TransactionEntity;

import java.time.LocalDateTime;

public class Transaction {
    private Long id;
    private Long customerId;
    private LocalDateTime datetime;
    private Long amount;

    public Transaction() {
    }

    public Transaction(Long id, Long customerId, LocalDateTime datetime, Long amount) {
        this.id = id;
        this.customerId = customerId;
        this.datetime = datetime;
        this.amount = amount;
    }

    // Does this practice(using constructor to convert dto and entity) reasonable?
    public Transaction(TransactionEntity transactionEntity){
        this.id = transactionEntity.getId();
        this.customerId = transactionEntity.getCustomerId();
        this.datetime = transactionEntity.getDatetime();
        this.amount = transactionEntity.getAmount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void getDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
