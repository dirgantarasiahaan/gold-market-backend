package com.mandiri.pocket.controller;

import com.mandiri.pocket.entity.Product;
import com.mandiri.pocket.entity.ProductHistoryPrice;
import com.mandiri.pocket.service.ProductHistoryPriceService;
import com.mandiri.pocket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductHistoryPriceService productHistoryPriceService;

    @PostMapping("/product")
    public Product createNew(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/products")
    public List<Product> searchProduct(){
        return productService.searchProduct();
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
       return productService.updateProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable(name = "id") String id){
        return productService.getProductById(id);
    }
    @GetMapping("/product/{id}/history")
    public List<ProductHistoryPrice> getHistoryProduct(@PathVariable(name = "id") String id){
        return productHistoryPriceService.findAllHistoryPricetbyId(id);
    }
}
