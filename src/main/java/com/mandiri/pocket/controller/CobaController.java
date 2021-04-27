package com.mandiri.pocket.controller;

import com.mandiri.pocket.entity.Car;
import com.mandiri.pocket.entity.Engine;
import com.mandiri.pocket.format.ResponseMessage;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("responseMessage")
    public ResponseMessage<Car> getCar1(){
        Engine engine = new Engine("asdsad",20,"asds");
        Car car = new Car("asdasdsad","putih","123",engine);
        return ResponseMessage.commandResponse(201, car);
    }

//    @GetMapping("ResponseEntity")
//    public ResponseEntity<Car> getCarEntity(){
//        Engine engine = new Engine("asdsad",20,"asds");
//        Car car = new Car("asdasdsad","putih","123",engine);
//        return ResponseEntity.status(201).body(ResponseMessage.commandResponse(1, car));
//    }

}
