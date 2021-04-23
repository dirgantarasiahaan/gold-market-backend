package com.mandiri.pocket.entity;

public class Engine {
    private String brand;
    private Integer cubical;
    private String series;

    public Engine(String brand, Integer cubical, String series) {
        this.brand = brand;
        this.cubical = cubical;
        this.series = series;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getCubical() {
        return cubical;
    }

    public void setCubical(Integer cubical) {
        this.cubical = cubical;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
