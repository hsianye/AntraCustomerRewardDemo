package com.example.customerreward.dao;

import com.example.customerreward.entity.TransactionEntity;
import com.example.customerreward.dto.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // equals to `SELECT t FROM TransactionEntity t WHERE t.customerId = :customerId AND t.datetime > :datetime`
    List<TransactionEntity> findByCustomerIdAndDatetimeAfter(Long customerId, LocalDateTime datetime);
}
