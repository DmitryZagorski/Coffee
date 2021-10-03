package com.epam.coffeewagon.wagon;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.coffee.condition.Condition;
import com.epam.coffeewagon.garage.Garage;
import com.epam.coffeewagon.garage.GarageService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WagonServiceTest {

    @Test
    void getCurrentCapacityOfCargoInWagon() {

        GarageService garageService = new GarageService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        Coffee coffee = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);

        for (Wagon wagon : Garage.getListOfWagon()) {
            if (wagon.getName().equals(wagonName)) {
                new WagonService().addCoffeeToWagon(wagonName, coffee);
            }
        }

        double result = Garage.getListOfWagon().get(0).getMaxCapacity()-coffee.getCapacity();
        Assert.assertTrue(result == 89);

    }

    @Test
    void getCurrentWeightOfCargoInWagon() {
    }

    @Test
    void getCurrentPriceOfCargoInWagon() {
    }

    @Test
    void addCoffeeToWagon() {
    }

    @Test
    void addCoffeeToWagonManually() {
        GarageService garageService = new GarageService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        Coffee coffee = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        for (Wagon wagon : Garage.getListOfWagon()) {
            if (wagon.getName().equals(wagonName)) {
                new WagonService().addCoffeeToWagon(wagonName, coffee);
            }
        }

        Assert.assertTrue(Garage.getListOfWagon().size() == 1);
        Assert.assertTrue(Garage.getListOfWagon().get(0).getName().equals(wagonName));
        Assert.assertTrue(Garage.getListOfWagon().get(0).getMaxPriceOfCargo() == 100.0);
        Assert.assertTrue(Garage.getListOfWagon().get(0).getMaxCapacity() == 90.0);
        Assert.assertTrue(Garage.getListOfWagon().get(0).getMaxWeightOfCargo() == 20.0);
    }

    @Test
    void removeCoffeeFromWagon() {
    }

    @Test
    void getListOfCoffeeInWagon() { // ???????
    }

    @Test
    void addCoffeeToWagonAutomatically() {
    }

    @Test
    void findCheepCoffeeInStore() {
    }
}