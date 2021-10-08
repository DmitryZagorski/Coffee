package com.epam.coffeewagon.wagon;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.coffee.condition.Condition;

import java.util.List;

public interface WagonServiceInterface {

    Double getCurrentCapacityOfCargoInWagon(String name);

    Double getCurrentWeightOfCargoInWagon(String name);

    Double getCurrentPriceOfCargoInWagon(String name);

    void addCoffeeToWagon(String wagonName, Coffee coffee);

    void removeCoffeeFromWagon(String wagonName, Coffee coffee);

    List<Coffee> getListOfCoffeeInWagon(String wagonName);

    void addCoffeeToWagonAutomatically(String wagonName, double maxPriceInWagon);

    void addCoffeeToWagonManually(String wagonName, String coffeeName, Condition condition);

}
