package com.wagon;

import com.coffee.Coffee;
import com.coffee.condition.Condition;
import com.garage.Garage;
import com.store.StoreInterface;
import com.store.StoreService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WagonService implements WagonServiceInterface {

    public Double getCurrentCapacityOfCargoInWagon(String name) {
        double currentCapacity = 0;
        for (Wagon wagon : Garage.getListOfWagon()) {
            if (wagon.getName().equals(name)) {
                currentCapacity = wagon.getMaxPriceOfCargo();
            }
            for (Coffee coffee : wagon.getCargoList()) {
                currentCapacity -= coffee.getCapacity();
            }
        }
        return currentCapacity;
    }

    public Double getCurrentWeightOfCargoInWagon(String name) {
        double currentWeight = 0;
        for (Wagon wagon : Garage.getListOfWagon()) {
            if (wagon.getName().equals(name)) {
                currentWeight = wagon.getMaxPriceOfCargo();
            }
            for (Coffee coffee : wagon.getCargoList()) {
                currentWeight -= coffee.getWeight();
            }
        }
        return currentWeight;
    }

    public Double getCurrentPriceOfCargoInWagon(String name) {
        double currentPrice = 0;
        for (Wagon wagon : Garage.getListOfWagon()) {
            if (wagon.getName().equals(name)) {
                currentPrice = wagon.getMaxPriceOfCargo();
            }
            for (Coffee coffee : wagon.getCargoList()) {
                currentPrice -= coffee.getPrice();
            }
        }
        return currentPrice;
    }

    public void addCoffeeToWagon(String wagonName, Coffee coffee) {
        for (Wagon wagon : Garage.getListOfWagon()) {
            if (wagon.getName().equals(wagonName)) {
                if (coffee.getWeight() <= getCurrentWeightOfCargoInWagon(wagonName) &&
                        coffee.getCapacity() <= getCurrentCapacityOfCargoInWagon(wagonName) &&
                        coffee.getPrice() <= getCurrentPriceOfCargoInWagon(wagonName)) {
                    wagon.getCargoList().add(coffee);
                    System.out.println(coffee.getName() + " - " +
                            coffee.getCondition() +" (price = "+ coffee.getPrice() + " )"+ " was added.");

                } else {
                    System.out.println("Full wagon. Free capacity equals " + getCurrentCapacityOfCargoInWagon(wagon.getName()) +
                            "Free wight equals " + getCurrentWeightOfCargoInWagon(wagon.getName()) +
                            "Free price equals" + getCurrentPriceOfCargoInWagon(wagon.getName()));
                }
            } else {
                System.out.println("No such wagon in wagonList");
            }
        }
    }

    public void addCoffeeToWagonManually(String wagonName, String coffeeName, Condition condition) {
        for (Wagon wagon : Garage.getListOfWagon()) {
            if (wagon.getName().equals(wagonName)) {
                for (Coffee coffee : new StoreService().getListOfCoffeeInStore()) {
                    if (coffee.getName().equals(coffeeName) && coffee.getCondition().equals(condition)) {
                        if (coffee.getWeight() <= getCurrentWeightOfCargoInWagon(wagonName) &&
                                coffee.getCapacity() <= getCurrentCapacityOfCargoInWagon(wagonName) &&
                                coffee.getPrice() <= getCurrentPriceOfCargoInWagon(wagonName)) {
                            wagon.getCargoList().add(coffee);
                            System.out.println(coffee.getName() + " - " +
                                    coffee.getCondition() +" (price = "+ coffee.getPrice() + " )"+ " was added.");
                            System.out.println("Free price: " + getCurrentPriceOfCargoInWagon(wagonName));
                        }
                        else {
                            System.out.println("Full wagon. Free capacity equals " + getCurrentCapacityOfCargoInWagon(wagon.getName())+"\n" +
                                    "Free wight equals " + getCurrentWeightOfCargoInWagon(wagon.getName()) + "\n" +
                                    "Free price equals " + getCurrentPriceOfCargoInWagon(wagon.getName()));
                        }
                    }
                }
            }
        }
    }

    public void removeCoffeeFromWagon(String wagonName, Coffee coffee) {
        for (Wagon wagon : Garage.getListOfWagon()) {
            if (wagon.getName().equals(wagonName)) {
                if (wagon.getCargoList().contains(coffee)) {
                    wagon.getCargoList().remove(coffee);
                } else {
                    System.out.println("No such coffee in wagon");
                }
            }
        }
    }

    public List<Coffee> getListOfCoffeeInWagon(String wagonName) {
        List<Coffee> coffeeList = new ArrayList<>();
        int firstSize = coffeeList.size();
        for (Wagon wagon : Garage.getListOfWagon()) {
            if (wagon.getName().equals(wagonName)) {
                coffeeList = wagon.getCargoList();
            } else {
                System.out.println("No such wagon");
            }
        }
        int secondSize = coffeeList.size();
        if (firstSize == secondSize) {
            System.out.println("WARNING! Empty list!");
        }
        return coffeeList;
    }

    public void addCoffeeToWagonAutomatically(String wagonName, double maxPriceInWagon) {
        Coffee first = new Coffee("Barista", Condition.BEANS, 1.0, 2.0, 10.0);
        Coffee second = new Coffee("Dallmayr", Condition.GROUND, 0.5, 1.0, 17.0);
        Coffee third = new Coffee("Lavazza", Condition.INSTANT_BAGS, 0.5, 2.0, 40.0);

        int price = (int) maxPriceInWagon / 3;
        for (int i = 0; i < price / first.getPrice(); i++) {
            if (first.getPrice() < getCurrentPriceOfCargoInWagon(wagonName)) {
                addCoffeeToWagon(wagonName, first);
            }
        }
        for (int i = 0; i < price / second.getPrice(); i++) {
            if (second.getPrice() < getCurrentPriceOfCargoInWagon(wagonName)) {
                addCoffeeToWagon(wagonName, second);
            }
        }
        for (int i = 0; i < price / third.getPrice(); i++) {
            if (third.getPrice() < getCurrentPriceOfCargoInWagon(wagonName)) {
                addCoffeeToWagon(wagonName, third);
            }
        }
        while (findCheepCoffeeInStore().getPrice()<getCurrentPriceOfCargoInWagon(wagonName)){
            addCoffeeToWagon(wagonName, findCheepCoffeeInStore());
        }
        System.out.println("Free price : " + getCurrentPriceOfCargoInWagon(wagonName) + "\n" +
                "Free wright : " + getCurrentWeightOfCargoInWagon(wagonName) + "\n" +
                "Free capacity : " + getCurrentCapacityOfCargoInWagon(wagonName));
    }

    public Coffee findCheepCoffeeInStore(){
        Coffee cheepCoffee;
        List<Coffee> sortedList = sortByName(new StoreService().getListOfCoffeeInStore());
        cheepCoffee = sortedList.get(0);
        return cheepCoffee;
    }

    public List<Coffee> sortByName(List<Coffee> list) {
        list.sort(Comparator.comparing(Coffee::getName));
        return list;
    }

    public List<Coffee> sortByPrice(List<Coffee> list) {
        list.sort(Comparator.comparing(Coffee::getPrice));
        return list;
    }

    public List<Coffee> sortByWeight(List<Coffee> list) {
        list.sort(Comparator.comparing(Coffee::getWeight));
        return list;
    }

    public List<Coffee> sortByPriceToWeight(List<Coffee> list) {
        list.sort(Comparator.comparing(Coffee::getPriceToWeight));
        return list;
    }

    public List<Coffee> sortByNameThenByPrice(List<Coffee> list) {
        list.sort(Comparator.comparing(Coffee::getName).thenComparing(Coffee::getPrice));
        return list;
    }

}
