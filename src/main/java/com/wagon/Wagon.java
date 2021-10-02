package com.wagon;

import com.coffee.Coffee;

import java.util.ArrayList;
import java.util.List;

public class Wagon {

    private String name;
    private double maxCapacity;
    private double maxWeightOfCargo;
    private double maxPriceOfCargo;
    private List<Coffee> cargoList;

    public Wagon(String name, double maxPriceOfCargo) {
        this.name = name;
        this.maxCapacity = 90;
        this.maxWeightOfCargo = 20;
        this.maxPriceOfCargo = maxPriceOfCargo;
        this.cargoList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public double getMaxWeightOfCargo() {
        return maxWeightOfCargo;
    }

    public double getMaxPriceOfCargo() {
        return maxPriceOfCargo;
    }

    public void setMaxPriceOfCargo(double maxPriceOfCargo) {
        this.maxPriceOfCargo = maxPriceOfCargo;
    }

    public List<Coffee> getCargoList() {
        return cargoList;
    }

}
