package com.mandiri.pocket.entity;

public class Car {

    private String name;
    private String color;
    private String brand;
    private Engine engine;

    public Car(String name, String color, String brand, Engine engine) {
        this.name = name;
        this.color = color;
        this.brand = brand;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
