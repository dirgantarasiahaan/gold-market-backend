package com.mandiri.pocket.controller;

import com.mandiri.pocket.entity.Customer;
import com.mandiri.pocket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") Integer id){
        return customerService.findCustomerById(id);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
        return customerService.findAllCustomer();
    }

    @PostMapping("/customer")
    public void saveCustomer(@RequestBody Customer customer){
         customerService.createCustomer(customer);
        HttpStatus.CREATED.toString();
    }

    @PutMapping("/customer/update")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customer/delete/{id}")
    public void deleteCustomer(@PathVariable(name = "id") Integer id){
        customerService.removeCustomer(id);
    }
}
