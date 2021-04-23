package com.mandiri.pocket.repository;

import com.mandiri.pocket.entity.ProductHistoryPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductHistoryPriceRepository extends JpaRepository<ProductHistoryPrice, String> {
}
