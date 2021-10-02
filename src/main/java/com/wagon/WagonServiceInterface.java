package com.wagon;

import com.coffee.Coffee;

import java.util.List;

public interface WagonServiceInterface {

    Double getCurrentCapacityOfCargoInWagon(String name);

    Double getCurrentWeightOfCargoInWagon(String name);

    Double getCurrentPriceOfCargoInWagon(String name);

    void addCoffeeToWagon(String wagonName, Coffee coffee);

    void removeCoffeeFromWagon(String wagonName, Coffee coffee);

    List<Coffee> getListOfCoffeeInWagon(String wagonName);

    void addCoffeeToWagonAutomatically(String wagonName, double maxPriceInWagon);

    List<Coffee> sortByName(List<Coffee> list);

    List<Coffee> sortByPrice(List<Coffee> list);

    List<Coffee> sortByWeight(List<Coffee> list);

    List<Coffee> sortByPriceToWeight(List<Coffee> list);

    List<Coffee> sortByNameThenByPrice(List<Coffee> list);

}
