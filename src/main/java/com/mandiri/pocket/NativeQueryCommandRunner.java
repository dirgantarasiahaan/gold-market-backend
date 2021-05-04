package com.mandiri.pocket;

import com.mandiri.pocket.dto.Prices;
import com.mandiri.pocket.entity.Customer;
import com.mandiri.pocket.entity.Product;
import com.mandiri.pocket.repository.CustomerRepository;
import com.mandiri.pocket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NativeQueryCommandRunner implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

//        List<Customer> customers = customerRepository.findActiveCustomer();
//        customers.stream().forEach(customer -> System.out.println(customer));

//        List<Customer> customerList = customerRepository.findAllCustomer();
//        customerList.stream().forEach(customer -> System.out.println(customer));

//        Product product = productRepository.findProductByName("tabanas");
//        System.out.println(product);


        List<Prices> prices = productRepository.prices();

        prices.stream().forEach(price -> System.out.println(price));

    }
}
