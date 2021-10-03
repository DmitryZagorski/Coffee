package com.epam.coffeewagon.garage;

import com.epam.coffeewagon.wagon.Wagon;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GarageServiceTest {

    @Test
    void addWagon() {
        GarageService garageService = new GarageService();
        garageService.addWagon("ff", 100.0);

        Assert.assertTrue(Garage.getListOfWagon().size() == 1);
        Assert.assertTrue(Garage.getListOfWagon().get(0).getName().equals("ff"));
        Assert.assertTrue(Garage.getListOfWagon().get(0).getMaxPriceOfCargo() == 100);
    }
}