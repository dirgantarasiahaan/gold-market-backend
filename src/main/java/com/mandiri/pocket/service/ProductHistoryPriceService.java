package com.mandiri.pocket.service;

import com.mandiri.pocket.entity.ProductHistoryPrice;

import java.util.List;

public interface ProductHistoryPriceService {

    public ProductHistoryPrice logPrice(ProductHistoryPrice productHistoryPrice);
    public List<ProductHistoryPrice> findAllPrice();
    public List<ProductHistoryPrice> findAllHistoryPricetbyId(String productId);

}
