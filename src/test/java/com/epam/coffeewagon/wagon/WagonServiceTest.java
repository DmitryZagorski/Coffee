package com.epam.coffeewagon.wagon;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.coffee.condition.Condition;
import com.epam.coffeewagon.garage.Garage;
import com.epam.coffeewagon.garage.GarageService;
import com.epam.coffeewagon.store.StoreService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

class WagonServiceTest {

    @Test
    void should_get_current_capacity_of_cargo_in_wagon() {
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        Coffee coffee1 = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        wagonService.addCoffeeToWagon(wagonName, coffee1);

        Assert.assertEquals(89.0, wagonService.getCurrentCapacityOfCargoInWagon(wagonName), 0.0);

    }

    @Test
    void should_get_current_weight_of_cargo_in_wagon() {
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        Coffee coffee1 = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        wagonService.addCoffeeToWagon(wagonName, coffee1);

        Assert.assertEquals(19.5, wagonService.getCurrentWeightOfCargoInWagon(wagonName), 0.0);
    }

    @Test
    void getCurrentPriceOfCargoInWagon() {
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        Coffee coffee1 = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        wagonService.addCoffeeToWagon(wagonName, coffee1);

        Assert.assertEquals(90.0, wagonService.getCurrentPriceOfCargoInWagon(wagonName), 0.0);

    }

    @Test
    void should_add_new_coffee_to_list_of_coffee_in_wagon() {
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        Coffee coffee1 = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        Coffee coffee2 = new Coffee("secondCoffee", Condition.GROUND, 5.0, 1.0, 20);
        wagonService.addCoffeeToWagon(wagonName, coffee1);
        wagonService.addCoffeeToWagon(wagonName, coffee2);

        Assert.assertEquals(new WagonService().getListOfCoffeeInWagon(wagonName).size(), 2);
        Assert.assertEquals(new WagonService().getListOfCoffeeInWagon(wagonName).get(1).getName(), ("secondCoffee"));
        Assert.assertEquals(new WagonService().getListOfCoffeeInWagon(wagonName).get(0).getCondition(), Condition.BEANS);


    }

    @Test
    void should_add_new_coffee_to_list_of_coffee_in_wagon_manually() {
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);

        wagonService.addCoffeeToWagonManually(wagonName, "Lavazza", Condition.BEANS);

        Assert.assertEquals(1, Garage.getListOfWagon().get(0).getCargoList().size());
        Assert.assertEquals("Lavazza", Garage.getListOfWagon().get(0).getCargoList().get(0).getName());
        Assert.assertEquals(20.0, Garage.getListOfWagon().get(0).getCargoList().get(0).getPrice(), 0.0);
    }

    @Test
    void should_remove_coffee_from_list_of_coffee_in_wagon() {
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        Coffee coffee1 = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        Coffee coffee2 = new Coffee("secondCoffee", Condition.GROUND, 5.0, 1.0, 20);
        wagonService.addCoffeeToWagon(wagonName, coffee1);
        wagonService.addCoffeeToWagon(wagonName, coffee2);

        wagonService.removeCoffeeFromWagon(wagonName, coffee1);

        Assert.assertEquals(1, Garage.getListOfWagon().get(0).getCargoList().size());
        Assert.assertEquals("secondCoffee", Garage.getListOfWagon().get(0).getCargoList().get(0).getName());

    }

    @Test
    void should_get_list_of_coffee_in_wagon() {
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        garageService.addWagon(wagonName, 100.0);
        Coffee coffee1 = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        Coffee coffee2 = new Coffee("secondCoffee", Condition.GROUND, 5.0, 1.0, 20);
        wagonService.addCoffeeToWagon(wagonName, coffee1);
        wagonService.addCoffeeToWagon(wagonName, coffee2);

        List<Coffee> actual = wagonService.getListOfCoffeeInWagon(wagonName);

        int expectedSize = 2;
        String expectedFirstName = "firstCoffee";

        Assert.assertEquals(expectedSize, actual.size());
        Assert.assertEquals(expectedFirstName, actual.get(0).getName());
    }

    @Test
    void should_add_new_coffee_to_list_of_coffee_in_wagon_automatically() {
        GarageService garageService = new GarageService();
        WagonService wagonService = new WagonService();
        String wagonName = "firstWagon";
        double maxPrice = 100.0;
        garageService.addWagon(wagonName, maxPrice);
        wagonService.addCoffeeToWagonAutomatically(wagonName, maxPrice);

        Assert.assertTrue(wagonService.getCurrentPriceOfCargoInWagon(wagonName)<100);
        Assert.assertTrue(Garage.getListOfWagon().get(0).getCargoList().size()>0);
        Assert.assertTrue(wagonService.getCurrentCapacityOfCargoInWagon(wagonName) < 90);
        Assert.assertTrue(wagonService.getCurrentWeightOfCargoInWagon(wagonName) < 20);

    }

    @Test
    void should_find_the_most_cheep_coffee_in_store() {
        StoreService storeService = new StoreService();
        WagonService wagonService = new WagonService();
        List<Coffee> list = storeService.getListOfCoffeeInStore();
        double minPrice = list.get(0).getPrice();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i+1).getPrice()<minPrice){
                minPrice = list.get(i+1).getPrice();
            }
        }
        double minPriceIViewInList = 10.0;

        Assert.assertEquals(minPrice, wagonService.findCheepCoffeeInStore().getPrice(), 0.0);
        Assert.assertEquals(minPriceIViewInList, wagonService.findCheepCoffeeInStore().getPrice(), 0.0);
    }
}