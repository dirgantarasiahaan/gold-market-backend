package com.mandiri.pocket.service;

import com.mandiri.pocket.entity.Pocket;

import java.util.List;

public interface PocketService {

    public Pocket getPocketById(String id);
    public List<Pocket> getAllPocket();
    public Pocket insertPocket(Pocket pocket);
}
