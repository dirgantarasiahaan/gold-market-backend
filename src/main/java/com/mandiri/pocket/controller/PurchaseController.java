package com.mandiri.pocket.controller;

import com.mandiri.pocket.entity.Purchase;
import com.mandiri.pocket.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/customer/{id}/purchases")
    public Purchase createPurchase(@PathVariable(name = "id") String customerId,
                                   @RequestBody Purchase purchase){
        return purchaseService.purchase(purchase, customerId);
    }

    @GetMapping("/purchases")
    public List<Purchase> findAllPurchase(){
        return purchaseService.findAllPurchase();
    }
}
