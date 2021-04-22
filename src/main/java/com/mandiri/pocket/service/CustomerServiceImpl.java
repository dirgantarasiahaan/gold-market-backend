package com.mandiri.pocket.service;

import com.mandiri.pocket.dto.CustomerSearchDto;
import com.mandiri.pocket.entity.Customer;
import com.mandiri.pocket.exception.CustomerNotFoundException;
import com.mandiri.pocket.repository.CustomerRepository;
import com.mandiri.pocket.specification.CustomerSpecification;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private static String notFoundMessage = "Customer with id : %s Not Found";

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(Integer id) {
        validatePresent(id);
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }

    @Override
    public Page<Customer> findAllCustomer(CustomerSearchDto customerSearchForm, Pageable pageable) {
//    public List<Customer> findAllCustomer(String firstname, String email, Date startDate, Date endDate, Pageable pageable) {
//        return customerRepository.findAll();
//        return customerRepository.findAllByFirstNameStartingWithAndEmailContaining(firstname, email, pageable);
//        return customerRepository.findAllByFirstNameStartingWithAndEmailContainingAndBirthDateBetween(customer, pageable);
        return customerRepository.findAll(CustomerSpecification.findCustomers(customerSearchForm), pageable);

//        Specification<Customer> specification = CustomerSpecification.findCustomers(customer),


    }


    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void updateCustomer(Customer customer) {
        validatePresent(customer.getId());
        customerRepository.save(customer);
            
    }

    private void validatePresent(Integer id) {
        if (!customerRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, id));
        }
    }

    @Override
    public void removeCustomer(Integer id ) {
        customerRepository.deleteById(id);
    }

  
}
