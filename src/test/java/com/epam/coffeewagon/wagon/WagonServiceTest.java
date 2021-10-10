package com.epam.coffeewagon.wagon;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.coffee.condition.Condition;
import com.epam.coffeewagon.garage.Garage;
import com.epam.coffeewagon.garage.GarageService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

class WagonServiceTest {

    @Test
    void should_get_current_capacity_of_cargo_in_wagon() {
        // given
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        Coffee coffee1 = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        // when
        wagonService.addCoffeeToWagon(wagonName, coffee1);
        // then
        Assert.assertEquals(89.0, wagonService.getCurrentCapacityOfCargoInWagon(wagonName), 0.0);
    }

    @Test
    void should_get_current_weight_of_cargo_in_wagon() {
        // given
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        Coffee coffee1 = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        // when
        wagonService.addCoffeeToWagon(wagonName, coffee1);
        // then
        Assert.assertEquals(19.5, wagonService.getCurrentWeightOfCargoInWagon(wagonName), 0.0);
    }

    @Test
    void getCurrentPriceOfCargoInWagon() {
        // given
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        Coffee coffee1 = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        // when
        wagonService.addCoffeeToWagon(wagonName, coffee1);
        // then
        Assert.assertEquals(90.0, wagonService.getCurrentPriceOfCargoInWagon(wagonName), 0.0);
    }

    @Test
    void should_add_new_coffee_to_list_of_coffee_in_wagon() {
        // given
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        Coffee coffee1 = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        Coffee coffee2 = new Coffee("secondCoffee", Condition.GROUND, 5.0, 1.0, 20);
        // when
        wagonService.addCoffeeToWagon(wagonName, coffee1);
        wagonService.addCoffeeToWagon(wagonName, coffee2);
        // then
        Assert.assertEquals(new WagonService().getListOfCoffeeInWagon(wagonName).size(), 2);
        Assert.assertEquals(new WagonService().getListOfCoffeeInWagon(wagonName).get(1).getName(), ("secondCoffee"));
        Assert.assertEquals(new WagonService().getListOfCoffeeInWagon(wagonName).get(0).getCondition(), Condition.BEANS);
    }

    @Test
    void should_add_new_coffee_to_list_of_coffee_in_wagon_manually() {
        // given
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        // when
        wagonService.addCoffeeToWagonManually(wagonName, "Lavazza", Condition.BEANS);
        // then
        Assert.assertEquals(1, Garage.getListOfWagon().get(0).getCargoList().size());
        Assert.assertEquals("Lavazza", Garage.getListOfWagon().get(0).getCargoList().get(0).getName());
        Assert.assertEquals(20.0, Garage.getListOfWagon().get(0).getCargoList().get(0).getPrice(), 0.0);
    }

    @Test
    void should_remove_coffee_from_list_of_coffee_in_wagon() {
        // given
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        Coffee coffee1 = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        Coffee coffee2 = new Coffee("secondCoffee", Condition.GROUND, 5.0, 1.0, 20);
        wagonService.addCoffeeToWagon(wagonName, coffee1);
        wagonService.addCoffeeToWagon(wagonName, coffee2);
        // when
        wagonService.removeCoffeeFromWagon(wagonName, coffee1);
        // then
        Assert.assertEquals(1, Garage.getListOfWagon().get(0).getCargoList().size());
        Assert.assertEquals("secondCoffee", Garage.getListOfWagon().get(0).getCargoList().get(0).getName());
    }

    @Test
    void should_get_list_of_coffee_in_wagon() {
        // given
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        Coffee coffee1 = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        Coffee coffee2 = new Coffee("secondCoffee", Condition.GROUND, 5.0, 1.0, 20);
        wagonService.addCoffeeToWagon(wagonName, coffee1);
        wagonService.addCoffeeToWagon(wagonName, coffee2);
        // when
        List<Coffee> actual = wagonService.getListOfCoffeeInWagon(wagonName);
        int expectedSize = 2;
        String expectedFirstName = "firstCoffee";
        // then
        Assert.assertEquals(expectedSize, actual.size());
        Assert.assertEquals(expectedFirstName, actual.get(0).getName());
    }

    @Test
    void should_add_new_coffee_to_list_of_coffee_in_wagon_automatically() {
        // given
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        double maxPrice = 100.0;
        garageService.addWagon(wagonName, maxPrice);
        // when
        wagonService.addCoffeeToWagonAutomatically(wagonName, maxPrice);
        // then
        Assert.assertTrue(wagonService.getCurrentPriceOfCargoInWagon(wagonName) < 100);
        Assert.assertTrue(Garage.getListOfWagon().get(0).getCargoList().size() > 0);
        Assert.assertTrue(wagonService.getCurrentCapacityOfCargoInWagon(wagonName) < 90);
        Assert.assertTrue(wagonService.getCurrentWeightOfCargoInWagon(wagonName) < 20);
    }

    @Test
    void should_find_the_most_cheep_coffee_in_store() {
        // given
        WagonService wagonService = new WagonService();
        // when
        double minPriceIViewInList = 10.0;
        // then
        Assert.assertEquals(minPriceIViewInList, wagonService.findCheepCoffeeInStore().getPrice(), 0.0);
    }
}