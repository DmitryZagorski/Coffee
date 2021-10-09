package com.epam.coffeewagon.wagon;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.coffee.condition.Condition;
import com.epam.coffeewagon.garage.Garage;
import com.epam.coffeewagon.main.Sorting;
import com.epam.coffeewagon.store.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class WagonService implements WagonServiceInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(WagonService.class.getSimpleName());

    public Double getCurrentCapacityOfCargoInWagon(String name) {
        LOGGER.info("Getting current capacity of cargo in wagon.");
        double currentCapacity = 0;
        for (Wagon wagon : Garage.getListOfWagon()) {
            if (wagon.getName().equals(name)) {
                currentCapacity = wagon.getMaxCapacity();
            }
            for (Coffee coffee : wagon.getCargoList()) {
                currentCapacity -= coffee.getCapacity();
            }
        }
        return currentCapacity;
    }

    public Double getCurrentWeightOfCargoInWagon(String name) {
        LOGGER.info("Getting current weight of cargo in wagon.");
        double currentWeight = 0;
        for (Wagon wagon : Garage.getListOfWagon()) {
            if (wagon.getName().equals(name)) {
                currentWeight = wagon.getMaxWeightOfCargo();
            }
            for (Coffee coffee : wagon.getCargoList()) {
                currentWeight -= coffee.getWeight();
            }
        }
        return currentWeight;
    }

    public Double getCurrentPriceOfCargoInWagon(String name) {
        LOGGER.info("Getting current price of cargo in wagon.");
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
        LOGGER.info("Adding new coffee '{}' to wagon, named {}", coffee, wagonName);
        for (Wagon wagon : Garage.getListOfWagon()) {
            if (wagon.getName().equals(wagonName)) {
                if (coffee.getWeight() <= getCurrentWeightOfCargoInWagon(wagonName) &&
                        coffee.getCapacity() <= getCurrentCapacityOfCargoInWagon(wagonName) &&
                        coffee.getPrice() <= getCurrentPriceOfCargoInWagon(wagonName)) {
                    wagon.getCargoList().add(coffee);
                    System.out.println(coffee.getName() + " - " +
                            coffee.getCondition() + " (price = " + coffee.getPrice() + " )" + " was added.");
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
        LOGGER.info("Adding manually coffee {} in condition {} to wagon, named {}.", coffeeName, condition, wagonName);
        for (Wagon wagon : Garage.getListOfWagon()) {
            if (wagon.getName().equals(wagonName)) {
                for (Coffee coffee : new StoreService().getListOfCoffeeInStore()) {
                    if (coffee.getName().equals(coffeeName) && coffee.getCondition().equals(condition)) {
                        if (coffee.getWeight() <= getCurrentWeightOfCargoInWagon(wagonName) &&
                                coffee.getCapacity() <= getCurrentCapacityOfCargoInWagon(wagonName) &&
                                coffee.getPrice() <= getCurrentPriceOfCargoInWagon(wagonName)) {
                            wagon.getCargoList().add(coffee);
                            System.out.println(coffee.getName() + " - " +
                                    coffee.getCondition() + " (price = " + coffee.getPrice() + " )" + " was added.");
                            System.out.println("Free price: " + getCurrentPriceOfCargoInWagon(wagonName));
                        } else {
                            System.out.println("Full wagon. Free capacity equals " + getCurrentCapacityOfCargoInWagon(wagon.getName()) + "\n" +
                                    "Free wight equals " + getCurrentWeightOfCargoInWagon(wagon.getName()) + "\n" +
                                    "Free price equals " + getCurrentPriceOfCargoInWagon(wagon.getName()));
                        }
                    }
                }
            }
        }
    }

    public void removeCoffeeFromWagon(String wagonName, Coffee coffee) {
        LOGGER.info("Removing coffee {} from wagon, named {}", coffee, wagonName);
        for (Wagon wagon : Garage.getListOfWagon()) {
            if (wagon.getName().equals(wagonName)) {
                for (Coffee coffee1 : wagon.getCargoList()) {
                    if (coffee1.getName().equals(coffee.getName())) {
                        wagon.getCargoList().remove(coffee);
                        System.out.println(coffee.getName() + " - " +
                                coffee.getCondition() + " (price = " + coffee.getPrice() + " )" + " was removed.");
                    } else {
                        System.out.println("No such coffee in wagon");
                    }
                }
            }
        }
    }

    public List<Coffee> getListOfCoffeeInWagon(String wagonName) {
        LOGGER.info("Getting list of coffee in wagon, named {}", wagonName);
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
            System.err.println("WARNING! Empty list!");
        }
        return coffeeList;
    }

    public void addCoffeeToWagonAutomatically(String wagonName, double maxPriceInWagon) {
        LOGGER.info("Adding coffee automatically to wagon, named {} with max price of cargo equals {}", wagonName, maxPriceInWagon);
        Coffee first = new Coffee("Barista", Condition.BEANS, 1.0, 0.1, 10.0);
        Coffee second = new Coffee("Dallmayr", Condition.GROUND, 0.5, 0.1, 17.0);
        Coffee third = new Coffee("Lavazza", Condition.INSTANT_BAGS, 0.5, 0.2, 40.0);

        addCoffeeAfterCheckingPrice(wagonName, first, maxPriceInWagon);
        addCoffeeAfterCheckingPrice(wagonName, second, maxPriceInWagon);
        addCoffeeAfterCheckingPrice(wagonName, third, maxPriceInWagon);

        if (findCheepCoffeeInStore().getPrice() < getCurrentPriceOfCargoInWagon(wagonName)) {
            addCoffeeToWagon(wagonName, findCheepCoffeeInStore());
        }
        System.out.println("Free price : " + getCurrentPriceOfCargoInWagon(wagonName) + "\n" +
                "Free weight : " + getCurrentWeightOfCargoInWagon(wagonName) + "\n" +
                "Free capacity : " + getCurrentCapacityOfCargoInWagon(wagonName));
    }

    private void addCoffeeAfterCheckingPrice(String wagonName, Coffee coffee, double maxPriceInWagon) {
        LOGGER.info("Checking free price in wagon, named {} with max price of cargo '{}' before adding new coffee '{}'", wagonName, maxPriceInWagon, coffee);
        int price = (int) maxPriceInWagon / 3;
        for (int i = 0; i < price / coffee.getPrice(); i++) {
            if (findCheepCoffeeInStore().getPrice() <= getCurrentPriceOfCargoInWagon(wagonName) &&
                    findCheepCoffeeInStore().getWeight() <= getCurrentWeightOfCargoInWagon(wagonName) &&
                    findCheepCoffeeInStore().getCapacity() <= getCurrentCapacityOfCargoInWagon(wagonName))
                addCoffeeToWagon(wagonName, coffee);
        }
    }

    public Coffee findCheepCoffeeInStore() {
        LOGGER.info("Finding most cheep coffee int store.");
        Coffee cheepCoffee;
        List<Coffee> sortedList = new Sorting().sortByName(new StoreService().getListOfCoffeeInStore());
        cheepCoffee = sortedList.get(0);
        return cheepCoffee;
    }
}
