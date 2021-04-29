package com.mandiri.pocket.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mandiri.pocket.entity.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface PurchaseService {

    public Purchase purchase(Purchase purchase, String customerId) throws JsonProcessingException;
    public Purchase findPurchaseById(String id);
    public Page<Purchase> findAllPurchase(Pageable pageable);
}
