package com.epam.coffeewagon.store;

import com.epam.coffeewagon.coffee.Coffee;

import java.util.List;

public interface StoreInterface {

    List<Coffee> getListOfCoffeeInStore();

    void addCoffeeToStore(Coffee coffee);

    void removeCoffeeFromStore(Coffee coffee);

}
