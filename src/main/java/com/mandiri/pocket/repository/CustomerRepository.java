package com.mandiri.pocket.repository;

import com.mandiri.pocket.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {

    public List<Customer> findAllByFirstNameStartingWithAndEmailContaining(String firstname, String email, Pageable pageable);
//    public List<Customer> findAllByFirstNameStartingWithAndEmailContainingAndBirthDateBetween(String firstname, String email, Date startDate, Date endDate, Pageable pageable);

}
