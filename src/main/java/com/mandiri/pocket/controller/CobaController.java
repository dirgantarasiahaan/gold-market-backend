package com.mandiri.pocket.controller;

import com.mandiri.pocket.entity.Car;
import com.mandiri.pocket.entity.Engine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CobaController {

    @GetMapping("/coba")
    public Car getCar(){
        Engine engine = new Engine("asdsad",20,"asds");
        Car car = new Car("asdasdsad","putih","123",engine);
        return car;
    }
}
