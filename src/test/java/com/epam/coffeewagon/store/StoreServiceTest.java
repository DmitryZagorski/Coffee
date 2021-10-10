package com.epam.coffeewagon.store;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.coffee.condition.Condition;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class StoreServiceTest {

    @Test
    void should_add_new_coffee_to_list_of_coffee_in_store() {
        StoreService storeService = new StoreService();
        int firstConditionOfList = storeService.getListOfCoffeeInStore().size();
        Coffee coffee = new Coffee("firstCoffee", Condition.BEANS, 1.0, 0.5, 10);
        storeService.addCoffeeToStore(coffee);

        int difference = storeService.getListOfCoffeeInStore().size()-firstConditionOfList;

        Assert.assertEquals(1, difference);

    }
}