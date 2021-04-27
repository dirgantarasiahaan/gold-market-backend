package com.mandiri.pocket.service;

import com.mandiri.pocket.entity.Pocket;

import java.util.List;
import java.util.Set;

public interface PocketService {

    public Pocket getPocketById(String id);
    public List<Pocket> getAllPocket();
    public Pocket insertPocket(Pocket pocket);
    public Pocket updatePocket(Pocket pocket);
    public void topUp(Pocket pocket, Double quantity);
    public void sellPocket(Pocket pocket, Double quantity);
    public Set<Pocket> findPocketsByCustomerId(String customerId);
}
