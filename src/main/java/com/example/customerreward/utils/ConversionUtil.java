package com.example.customerreward.utils;

import com.example.customerreward.dto.Customer;
import com.example.customerreward.dto.Transaction;
import com.example.customerreward.entity.CustomerEntity;
import com.example.customerreward.entity.TransactionEntity;

public class ConversionUtil {

    private ConversionUtil() {
    }

    public static Customer toCustomerDto(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(customerEntity.getId());
        customer.setName(customerEntity.getName());
        return customer;
    }

    public static CustomerEntity toCustomerEntity(Customer customerDto) {
        if (customerDto == null) {
            return null;
        }
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerDto.getId());
        customerEntity.setName(customerDto.getName());
        return customerEntity;
    }

    public static Transaction toTransactionDto(TransactionEntity transactionEntity) {
        if (transactionEntity == null) {
            return null;
        }
        Transaction transaction = new Transaction();
        transaction.setId(transactionEntity.getId());
        transaction.setCustomer(new Customer(
                transactionEntity.getCustomer().getId(),
                transactionEntity.getCustomer().getName()
        ));
        transaction.setDatetime(transactionEntity.getDatetime());
        transaction.setAmount(transactionEntity.getAmount());
        return transaction;
    }

    public static TransactionEntity toTransactionEntity(Transaction transactionDto) {
        if (transactionDto == null) {
            return null;
        }
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(transactionDto.getId());
        transactionEntity.setCustomer(new CustomerEntity(
                transactionDto.getCustomer().getId(),
                transactionDto.getCustomer().getName()
        ));
        transactionEntity.setDatetime(transactionDto.getDatetime());
        transactionEntity.setAmount(transactionDto.getAmount());
        return transactionEntity;
    }
}
