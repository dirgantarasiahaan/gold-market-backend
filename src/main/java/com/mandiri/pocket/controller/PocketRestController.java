package com.mandiri.pocket.controller;

import com.mandiri.pocket.entity.Pocket;
import com.mandiri.pocket.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PocketRestController {

    @Autowired
    PocketService pocketService;

    @PostMapping("/pocket")
    public Pocket insertPocket(@RequestBody Pocket pocket){
        return pocketService.insertPocket(pocket);
    }

    @GetMapping("/pocket/{id}")
    public Pocket findPocketById(@PathVariable(name = "id") String pocketId){
        return pocketService.getPocketById(pocketId);
    }

    @GetMapping("/customer/{id}/pockets")
    public Set<Pocket> findPocketsByCustomerId(@PathVariable(name = "id") String customerId){
        return pocketService.findPocketsByCustomerId(customerId);
    }

    @GetMapping("/pockets")
    public Page<Pocket> findAllPocket(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                      @RequestParam(name = "size", defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return pocketService.getAllPocket(pageable);
    }
}
