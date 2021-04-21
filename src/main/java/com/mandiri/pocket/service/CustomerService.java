package com.mandiri.pocket.service;

import com.mandiri.pocket.entity.Customer;

import java.util.List;

public interface CustomerService {

    public Customer findCustomerById(Integer id);
    public List<Customer> findAllCustomer();
    public void createCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void removeCustomer(Integer id);
}
