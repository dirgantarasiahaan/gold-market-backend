package com.mandiri.pocket.controller;

import com.mandiri.pocket.entity.Pocket;
import com.mandiri.pocket.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PocketRestController {

    @Autowired
    PocketService pocketService;

    @PostMapping("/pocket")
    public Pocket insertPocket(@RequestBody Pocket pocket){
        return pocketService.insertPocket(pocket);
    }
}
