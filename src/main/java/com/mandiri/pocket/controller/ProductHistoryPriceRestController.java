package com.mandiri.pocket.controller;

import com.mandiri.pocket.entity.Product;
import com.mandiri.pocket.entity.ProductHistoryPrice;
import com.mandiri.pocket.service.ProductHistoryPriceService;
import com.mandiri.pocket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductHistoryPriceRestController {

    @Autowired
    ProductHistoryPriceService productHistoryPriceService;


    @GetMapping("/product/price/get")
    public List<ProductHistoryPrice> findAllHistoryProduct(){
        return productHistoryPriceService.findAllPrice();
    }
}
