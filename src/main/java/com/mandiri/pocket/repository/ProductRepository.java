package com.mandiri.pocket.repository;

import com.mandiri.pocket.dto.Prices;
import com.mandiri.pocket.entity.Product;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = "SELECT * FROM m_products p where p.product_name = :productName ", nativeQuery = true)
    Product findProductByName(@Param("productName") String productName);

    @Query(value = "SELECT new com.mandiri.pocket.dto.Prices(p.productPriceSell, p.productPriceBuy) FROM Product p")
    List<Prices> prices();


}
