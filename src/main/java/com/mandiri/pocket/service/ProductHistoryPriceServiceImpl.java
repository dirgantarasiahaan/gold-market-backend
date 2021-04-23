package com.mandiri.pocket.service;

import com.mandiri.pocket.entity.Product;
import com.mandiri.pocket.entity.ProductHistoryPrice;
import com.mandiri.pocket.repository.ProductHistoryPriceRepository;
import com.mandiri.pocket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductHistoryPriceServiceImpl implements ProductHistoryPriceService{

    @Autowired
    ProductHistoryPriceRepository productHistoryPriceRepository;

    @Autowired
    ProductService productService;

    @Override
    public ProductHistoryPrice logPrice(ProductHistoryPrice productHistoryPrice) {
        return productHistoryPriceRepository.save(productHistoryPrice);
    }

    @Override
    public List<ProductHistoryPrice> findAllPrice() {
        return productHistoryPriceRepository.findAll();
    }

    @Override
    public List<ProductHistoryPrice> findAllHistoryPricetbyId(String productId) {
        Product product = productService.getProductById(productId);
        return product.getHistoryPrice();
    }
}
