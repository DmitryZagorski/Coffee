package com.epam.coffeewagon.garage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GarageServiceTest {

    @Test
    void should_add_new_wagon_to_list_of_wagon() {
        GarageService garageService = new GarageService();
        garageService.addWagon("ff", 100.0);

        Assert.assertEquals(1, Garage.getListOfWagon().size());
        Assert.assertEquals("ff", Garage.getListOfWagon().get(0).getName());
        Assert.assertEquals(100, Garage.getListOfWagon().get(0).getMaxPriceOfCargo(), 0.0);
    }
}