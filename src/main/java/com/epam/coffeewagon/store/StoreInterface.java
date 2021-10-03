package com.epam.coffeewagon.store;

import com.epam.coffeewagon.coffee.Coffee;

import java.util.List;

public interface StoreInterface {

    List<Coffee> getListOfCoffeeInStore();

    List<Coffee> addCoffeeToStore(Coffee coffee);

    List<Coffee> removeCoffeeFromStore(Coffee coffee);

}
