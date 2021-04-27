package com.mandiri.pocket.service;

import com.mandiri.pocket.entity.Customer;
import com.mandiri.pocket.entity.Pocket;
import com.mandiri.pocket.repository.PocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Service
public class PocketServiceImpl implements PocketService{

    private static String notFoundMessage = "Pocket with id : %s Not Found";
    private static String existingPocketMessage = "your total pocket only : %f.2f";

    @Autowired
    PocketRepository pocketRepository;

    @Autowired
    CustomerService customerService;

    @Override
    public Pocket getPocketById(String id) {
        validatePocket(id);
        return pocketRepository.findById(id).get();
    }

    @Override
    public Page<Pocket> getAllPocket(Pageable pageable) {
        return pocketRepository.findAll(pageable);
    }

    @Override
    public Pocket insertPocket(Pocket pocket) {
        pocket.setPocketQty(0.0);
        return pocketRepository.save(pocket);
    }

    @Override
    public Pocket updatePocket(Pocket pocket) {
        validatePocket(pocket.getId());
        return pocketRepository.save(pocket);
    }

    @Override
    public void topUp(Pocket pocket, Double quantity) {
        pocket.setPocketQty(pocket.getPocketQty() + quantity);
        pocketRepository.save(pocket);
    }

    @Override
    public void sellPocket(Pocket pocket, Double quantity) {
        if (pocket.getPocketQty() < quantity){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format(existingPocketMessage,pocket.getPocketQty()));
        }
        pocket.setPocketQty(pocket.getPocketQty()-quantity);
        pocketRepository.save(pocket);
    }

    @Override
    public Set<Pocket> findPocketsByCustomerId(String customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        return customer.getPockets();
    }

    private void validatePocket(String id) {
        if (!pocketRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, id));
        }
    }
}
