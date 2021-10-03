package com.store;

import com.coffee.Coffee;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Coffee> storeList;
    private double storeCapacity;

    public Store(double storeCapacity) {
        this.storeCapacity = storeCapacity;
        this.storeList = new ArrayList<>();
    }

    public List<Coffee> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Coffee> storeList) {
        this.storeList = storeList;
    }

    public double getStoreCapacity() {
        return storeCapacity;
    }

    public void setStoreCapacity(double storeCapacity) {
        this.storeCapacity = storeCapacity;
    }
}
