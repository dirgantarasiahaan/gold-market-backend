package com.mandiri.pocket.service;

import com.mandiri.pocket.entity.Customer;
import com.mandiri.pocket.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(Integer id) {
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void removeCustomer(Integer id ) {
        customerRepository.deleteById(id);
    }
}
