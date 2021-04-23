package com.mandiri.pocket.service;

import com.mandiri.pocket.entity.Product;
import com.mandiri.pocket.entity.ProductHistoryPrice;
import com.mandiri.pocket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductHistoryPriceService productHistoryPriceService;

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        product.setCreatedAt(new Timestamp(new Date().getTime()));
        return persistProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return persistProduct(product);
    }

    @Override
    public List<Product> searchProduct() {
        return productRepository.findAll();
    }

    private Product persistProduct(Product product) {
        product.setUpdatedAt(new Timestamp(new Date().getTime()));
        Product saveProduct = productRepository.save(product);
        productHistoryPriceService.logPrice(new ProductHistoryPrice(saveProduct));
        return saveProduct;
    }
}
