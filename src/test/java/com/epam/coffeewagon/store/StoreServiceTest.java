package com.epam.coffeewagon.store;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.coffee.condition.Condition;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

class StoreServiceTest {

    @Test
    void getListOfCoffeeInStore() {
        StoreService storeService = new StoreService();
        List<Coffee> actual = storeService.listOfCoffeeInStore;

        Assert.assertEquals(12, actual.size());

    }

    @Test
    void addCoffeeToStore() {
        StoreService storeService = new StoreService();
        int firstConditionOfList = storeService.getListOfCoffeeInStore().size();
        Coffee coffee = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        storeService.addCoffeeToStore(coffee);

        int difference = storeService.getListOfCoffeeInStore().size()-firstConditionOfList;

        Assert.assertEquals(1, difference);

    }

    @Test
    void removeCoffeeFromStore() {
        StoreService storeService = new StoreService();
        int firstConditionOfList = storeService.getListOfCoffeeInStore().size();
        Coffee coffee = new Coffee("Barista", Condition.BEANS, 1.0, 2.0, 10.0);
        storeService.removeCoffeeFromStore(coffee);

        int difference = firstConditionOfList - storeService.getListOfCoffeeInStore().size();

        Assert.assertEquals(1, difference);

    }
}