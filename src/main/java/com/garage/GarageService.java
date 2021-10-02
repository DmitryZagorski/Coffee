package com.garage;

import com.wagon.Wagon;

import static com.garage.Garage.getListOfWagon;

public class GarageService implements GarageServiceInterface {

    public void addWagon(String name, Double maxPriceOfCargo) {

        getListOfWagon().add(new Wagon(name, maxPriceOfCargo));
    }

    /*
    @Override
    public void addWagon(String name, Double maxPriceOfCargo) {
        int count = 0;
        for (Wagon wagon : getListOfWagon()) {
            if (wagon.getName().equals(name)){
                count++;
            }
        }
        if (count!=0){
            getListOfWagon().add(new Wagon(name, maxPriceOfCargo));
        }
    }*/
}
