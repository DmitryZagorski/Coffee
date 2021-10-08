package com.epam.coffeewagon.main;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.coffee.condition.Condition;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SortingTest {

    @Test
    void sortByName() {

        Coffee coffee1 = new Coffee("Ka", Condition.INSTANT_CANS, 1.0, 1.0, 20.0);
        Coffee coffee2 = new Coffee("Za", Condition.INSTANT_CANS, 1.0, 1.0, 20.0);
        Coffee coffee3 = new Coffee("At", Condition.INSTANT_CANS, 1.0, 1.0, 20.0);
        List<Coffee> list = Arrays.asList(coffee1, coffee2, coffee3);
        Sorting sorting = new Sorting();
        sorting.sortByName(list);

        Assert.assertEquals("At", list.get(0).getName());
        Assert.assertEquals("Za", list.get(2).getName());
    }

    @Test
    void sortByPrice() {

        Coffee coffee1 = new Coffee("Ka", Condition.INSTANT_CANS, 1.0, 1.0, 15.0);
        Coffee coffee2 = new Coffee("Za", Condition.INSTANT_CANS, 1.0, 1.0, 50.0);
        Coffee coffee3 = new Coffee("At", Condition.INSTANT_CANS, 1.0, 1.0, 10.0);
        List<Coffee> list = Arrays.asList(coffee1, coffee2, coffee3);
        Sorting sorting = new Sorting();
        sorting.sortByPrice(list);
        Assert.assertTrue(10.0 == list.get(0).getPrice());
        Assert.assertTrue(50.0 == list.get(2).getPrice());

    }

    @Test
    void sortByWeight() {
        Coffee coffee1 = new Coffee("Ka", Condition.INSTANT_CANS, 1.0, 2.0, 15.0);
        Coffee coffee2 = new Coffee("Za", Condition.INSTANT_CANS, 1.0, 3.0, 50.0);
        Coffee coffee3 = new Coffee("At", Condition.INSTANT_CANS, 1.0, 1.0, 10.0);
        List<Coffee> list = Arrays.asList(coffee1, coffee2, coffee3);
        Sorting sorting = new Sorting();
        sorting.sortByWeight(list);
        Assert.assertTrue(1.0 == list.get(0).getWeight());
        Assert.assertTrue(3.0 == list.get(2).getWeight());
    }

    @Test
    void sortByPriceToWeight() {
        Coffee coffee1 = new Coffee("Ka", Condition.INSTANT_CANS, 1.0, 2.0, 15.0);
        Coffee coffee2 = new Coffee("Za", Condition.INSTANT_CANS, 1.0, 3.0, 50.0);
        Coffee coffee3 = new Coffee("At", Condition.INSTANT_CANS, 1.0, 1.0, 10.0);
        List<Coffee> list = Arrays.asList(coffee1, coffee2, coffee3);
        double max = list.get(1).getPrice() / list.get(1).getWeight();
        Sorting sorting = new Sorting();
        sorting.sortByPriceToWeight(list);

        Assert.assertTrue(max == list.get(2).getPrice() / list.get(2).getWeight());

    }

}