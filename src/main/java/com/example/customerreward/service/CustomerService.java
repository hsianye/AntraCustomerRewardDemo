package com.example.customerreward.service;

import com.example.customerreward.dao.CustomerRepository;
import com.example.customerreward.dao.TransactionRepository;
import com.example.customerreward.dto.Reward;
import com.example.customerreward.entity.TransactionEntity;
import com.example.customerreward.dto.Customer;
import com.example.customerreward.dto.Transaction;
import com.example.customerreward.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.NoTransactionException;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Service("customerService")
public class CustomerService {
    private CustomerRepository customerRepository;
    private TransactionRepository transactionRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository,
                           TransactionRepository transactionRepository) {
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    public Customer createCustomer(Customer customer){
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    public Transaction createTransaction(Transaction transaction){
        Transaction savedTransaction = transactionRepository.save(transaction);
        return savedTransaction;
    }

    public Reward getRewardsForCustomerInLastThreeMonths(Long customerId){
        // Check if customer exist
        if(!customerRepository.existsById(customerId)){
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found");
        }

        // Filter the transactions in 3 months
        // Raise error if transaction doesn't exist
        LocalDateTime threeMonthsAgo = LocalDateTime.now().minusMonths(3);
        List<TransactionEntity> transactions = transactionRepository.findByCustomerIdAndDatetimeAfter(
                customerId, threeMonthsAgo);
        if(transactions.isEmpty()){
            throw new NoTransactionException("Customer with ID " + customerId + " has no transaction in 3 months");
        }
        Long totalRewards = transactions
                .stream()
                .mapToLong(t -> calculateReward(t.getAmount()))
                .sum();
        Map<String, Long> monthlyRewards = transactions
                .stream()
                .collect(Collectors.groupingBy(
                        // Grouping Function
                        // To process every element, and group by the result of function
                        // In this case, group by the name of month
                        t -> t.getDatetime().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH),
                        // Summarizing Collector
                        // Also applied on each element, the result serves as the value of map
                        // While the result of grouping function serves as key
                        Collectors.summingLong(t -> calculateReward(t.getAmount()))
                ));
        return new Reward(customerId, totalRewards, monthlyRewards);
    }

    private Long calculateReward(Long amount){
        if(amount > 100)
            return 50+ (amount-100)*2;
        else if(amount > 50)
            return amount-50;
        else
            return 0L;
    }
}
