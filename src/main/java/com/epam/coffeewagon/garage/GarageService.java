package com.garage;

import com.wagon.Wagon;

import java.util.ArrayList;
import java.util.List;

import static com.garage.Garage.getListOfWagon;

public class GarageService implements GarageServiceInterface {

    public void addWagon(String name, Double maxPriceOfCargo) {

        getListOfWagon().add(new Wagon(name, maxPriceOfCargo));
    }
}
