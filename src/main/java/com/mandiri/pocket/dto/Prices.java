package com.mandiri.pocket.dto;

import java.math.BigDecimal;

public class Prices {

    private BigDecimal productPriceBuy;
    private BigDecimal productPriceSell;

    public Prices() {
    }

    public Prices(BigDecimal productPriceBuy, BigDecimal productPriceSell) {
        this.productPriceBuy = productPriceBuy;
        this.productPriceSell = productPriceSell;
    }

    public BigDecimal getProductPriceBuy() {
        return productPriceBuy;
    }

    public void setProductPriceBuy(BigDecimal productPriceBuy) {
        this.productPriceBuy = productPriceBuy;
    }

    public BigDecimal getProductPriceSell() {
        return productPriceSell;
    }

    public void setProductPriceSell(BigDecimal productPriceSell) {
        this.productPriceSell = productPriceSell;
    }

    @Override
    public String toString() {
        return "Prices{" +
                "productPriceBuy=" + productPriceBuy +
                ", productPriceSell=" + productPriceSell +
                '}';
    }
}
