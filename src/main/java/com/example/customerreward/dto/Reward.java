package com.example.customerreward.dto;

import java.util.Map;


public class Reward {
    private Long customerId;
    private Long totalRewards;
    private Map<String, Long> monthlyRewards;

    public Reward() {
    }

    public Reward(Long customerId, Long totalRewards, Map<String, Long> monthlyRewards) {
        this.customerId = customerId;
        this.totalRewards = totalRewards;
        this.monthlyRewards = monthlyRewards;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(Long totalRewards) {
        this.totalRewards = totalRewards;
    }

    public Map<String, Long> getMonthlyRewards() {
        return monthlyRewards;
    }

    public void setMonthlyRewards(Map<String, Long> monthlyRewards) {
        this.monthlyRewards = monthlyRewards;
    }
}

