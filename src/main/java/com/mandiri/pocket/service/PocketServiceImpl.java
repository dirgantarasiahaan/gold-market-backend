package com.mandiri.pocket.service;

import com.mandiri.pocket.entity.Pocket;
import com.mandiri.pocket.repository.PocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PocketServiceImpl implements PocketService{

    @Autowired
    PocketRepository pocketRepository;

    @Override
    public Pocket getPocketById(String id) {
        return null;
    }

    @Override
    public List<Pocket> getAllPocket() {
        return null;
    }

    @Override
    public Pocket insertPocket(Pocket pocket) {
        return pocketRepository.save(pocket);
    }
}
