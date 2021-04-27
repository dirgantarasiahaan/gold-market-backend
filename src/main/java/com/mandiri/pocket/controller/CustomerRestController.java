package com.mandiri.pocket.controller;

import com.mandiri.pocket.dto.CustomerSearchDto;
import com.mandiri.pocket.entity.Customer;
import com.mandiri.pocket.entity.Product;
import com.mandiri.pocket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") String id){
        return customerService.findCustomerById(id);
    }

    @GetMapping("/customers")
    public Page<Customer> getAllCustomer(@RequestBody CustomerSearchDto customerSearchForm,
                                         @RequestParam(name = "page", defaultValue = "0") Integer page,
                                         @RequestParam(name = "size", defaultValue = "10") Integer size) throws ParseException {

        Pageable pageable = PageRequest.of(page,size);
        return customerService.findAllCustomer(customerSearchForm, pageable);
    }

    @PostMapping("/customer")
    public void saveCustomer(@RequestBody Customer customer){
         customerService.createCustomer(customer);
    }

    @PutMapping("/customer/update")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customer/delete/{id}")
    public void deleteCustomer(@PathVariable(name = "id") String id){
        customerService.removeCustomer(id);
    }
}
