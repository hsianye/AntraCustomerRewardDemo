package com.example.customerreward.entity;

import com.example.customerreward.dto.Transaction;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Long customerId;

    @NotNull
    @Column(name = "datetime")
    private LocalDateTime datetime;

    @NotNull
    @Column(name = "amount")
    private Long amount;

    public TransactionEntity() {
    }

    public TransactionEntity(Long id, Long customerId, LocalDateTime datetime, Long amount) {
        this.id = id;
        this.customerId = customerId;
        this.datetime = datetime;
        this.amount = amount;
    }

    // Does this practice(using constructor to convert dto and entity) reasonable?
    public TransactionEntity(Transaction transaction){
        this.id = transaction.getId();
        this.customerId = transaction.getCustomerId();
        this.datetime = transaction.getDatetime();
        this.amount = transaction.getAmount();
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
