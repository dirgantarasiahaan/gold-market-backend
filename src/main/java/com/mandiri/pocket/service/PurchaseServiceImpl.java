package com.mandiri.pocket.service;

import com.mandiri.pocket.entity.Customer;
import com.mandiri.pocket.entity.Pocket;
import com.mandiri.pocket.entity.Purchase;
import com.mandiri.pocket.entity.PurchaseDetail;
import com.mandiri.pocket.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    private static String notFoundPurchaseType = "Purchase Type : %d NOT FOUND!";

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    PocketService pocketService;

    @Override
    public Purchase purchase(Purchase purchase, String customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        purchase.setCustomer(customer);
        purchase.setPurchaseDate(new Date());

        if (purchase.getPurchaseType() == 0){
           topUp(purchase);
        } else if (purchase.getPurchaseType() == 1){
            sellQuantityPocket(purchase);
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format(notFoundPurchaseType, purchase.getPurchaseType()));

        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase findPurchaseById(String id) {
        return purchaseRepository.findById(id).get();
    }

    @Override
    public Page<Purchase> findAllPurchase(Pageable pageable) {
        return purchaseRepository.findAll(pageable);
    }

    private Purchase topUp(Purchase purchase){
        for (PurchaseDetail purchaseDetails: purchase.getPurchaseDetails()) {
            Pocket pocket = pocketService.getPocketById(purchaseDetails.getPocket().getId());
            pocketService.topUp(pocket, purchaseDetails.getQuantityInGram());
            purchaseDetails.setProduct(pocket.getProduct());
            purchaseDetails.setPrice(pocket.getProduct().getProductPriceSell());
            purchaseDetails.setPurchase(purchase);
        }
        return purchase;
    }

    private Purchase sellQuantityPocket(Purchase purchase){
        for (PurchaseDetail purchaseDetails: purchase.getPurchaseDetails()) {
            Pocket pocket = pocketService.getPocketById(purchaseDetails.getPocket().getId());
            pocketService.sellPocket(pocket, purchaseDetails.getQuantityInGram());
            purchaseDetails.setProduct(pocket.getProduct());
            purchaseDetails.setPrice(pocket.getProduct().getProductPriceBuy());
            purchaseDetails.setPurchase(purchase);
        }
        return purchase;
    }

}
