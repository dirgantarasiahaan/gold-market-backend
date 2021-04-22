package com.mandiri.pocket.service;

import com.mandiri.pocket.dto.CustomerSearchDto;
import com.mandiri.pocket.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface CustomerService {

    public Customer findCustomerById(Integer id);
//    public List<Customer> findAllCustomer(String firstName, String email, Date startDate, Date endDate, Pageable pageable);
public Page<Customer> findAllCustomer(CustomerSearchDto customer, Pageable pageable);
    public void createCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void removeCustomer(Integer id);
}
