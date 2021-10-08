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
        printLoggerToGettingCapacity();
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

    private void printLoggerToGettingCapacity() {
        LOGGER.info("Getting current capacity of cargo in wagon.");
    }

    public Double getCurrentWeightOfCargoInWagon(String name) {
        printLoggerToGettingWeight();
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

    private void printLoggerToGettingWeight() {
        LOGGER.info("Getting current weight of cargo in wagon.");
    }

    public Double getCurrentPriceOfCargoInWagon(String name) {
        printLoggerToGettingPrice();
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

    private void printLoggerToGettingPrice() {
        LOGGER.info("Getting current price of cargo in wagon.");
    }

    public void addCoffeeToWagon(String wagonName, Coffee coffee) {
        printLoggerToAddingCoffeeToWagon();
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

    private void printLoggerToAddingCoffeeToWagon() {
        LOGGER.info("Started method 'addCoffeeToWagon' " +
                "with arguments 'wagonName' and 'coffee'");
    }

    public void addCoffeeToWagonManually(String wagonName, String coffeeName, Condition condition) {
        printLoggerToAddingCoffeeToWagonManually();
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

    private void printLoggerToAddingCoffeeToWagonManually() {
        LOGGER.info("Started method 'addCoffeeToWagonManually' " +
                "with arguments 'wagonName', 'coffeeName' and 'condition'");
    }

    public void removeCoffeeFromWagon(String wagonName, Coffee coffee) {
        printLoggerToRemoveCoffeeFromWagon();
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

    private void printLoggerToRemoveCoffeeFromWagon() {
        LOGGER.info("Started method 'removeCoffeeFromWagon' " +
                "with arguments 'wagonName' and 'coffee'");
    }

    public List<Coffee> getListOfCoffeeInWagon(String wagonName) {
        printLoggerToGettingListOfCoffeeInWagon();
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

    private void printLoggerToGettingListOfCoffeeInWagon() {
        LOGGER.info("Started method 'removeCoffeeFromWagon' " +
                "with arguments 'wagonName' and 'coffee'");
    }

    public void addCoffeeToWagonAutomatically(String wagonName, double maxPriceInWagon) {
        printLoggerToAddingCoffeeToWagonAutomatically();
        Coffee first = new Coffee("Barista", Condition.BEANS, 1.0, 2.0, 10.0);
        Coffee second = new Coffee("Dallmayr", Condition.GROUND, 0.5, 1.0, 17.0);
        Coffee third = new Coffee("Lavazza", Condition.INSTANT_BAGS, 0.5, 2.0, 40.0);

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

    private void printLoggerToAddingCoffeeToWagonAutomatically() {
        LOGGER.info("Started method 'addCoffeeToWagonAutomatically' " +
                "with arguments 'wagonName' and 'maxPriceInWagon'");
    }

    private void addCoffeeAfterCheckingPrice(String wagonName, Coffee coffee, double maxPriceInWagon) {
        printLoggerToAddingCoffeeAfterCheckingPrice();
        int price = (int) maxPriceInWagon / 3;
        for (int i = 0; i < price / coffee.getPrice(); i++) {
            if (findCheepCoffeeInStore().getPrice() <= getCurrentPriceOfCargoInWagon(wagonName) &&
                    findCheepCoffeeInStore().getWeight() <= getCurrentWeightOfCargoInWagon(wagonName) &&
                    findCheepCoffeeInStore().getCapacity() <= getCurrentCapacityOfCargoInWagon(wagonName))
                addCoffeeToWagon(wagonName, coffee);
        }
    }

    private void printLoggerToAddingCoffeeAfterCheckingPrice() {
        LOGGER.info("Started method 'addCoffeeAfterCheckingPrice' " +
                "with arguments 'wagonName', 'coffee' and 'maxPriceInWagon'");
    }

    public Coffee findCheepCoffeeInStore() {
        printLoggerToFindingCheepCoffeeInStore();
        Coffee cheepCoffee;
        List<Coffee> sortedList = new Sorting().sortByName(new StoreService().getListOfCoffeeInStore());
        cheepCoffee = sortedList.get(0);
        return cheepCoffee;
    }

    private void printLoggerToFindingCheepCoffeeInStore() {
        LOGGER.info("Started method 'findCheepCoffeeInStore' " +
                "without arguments");
    }

}
