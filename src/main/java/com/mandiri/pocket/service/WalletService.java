package com.mandiri.pocket.service;

import com.mandiri.pocket.entity.Customer;

import java.math.BigDecimal;

public interface WalletService {

    public void debitWaller(Customer customer, BigDecimal amount);
}
