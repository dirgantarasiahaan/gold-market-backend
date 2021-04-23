package com.mandiri.pocket.service;

import com.mandiri.pocket.entity.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(String id);
    public Product saveProduct(Product product);
    public List<Product> searchProduct();
    public Product updateProduct(Product product);

}
