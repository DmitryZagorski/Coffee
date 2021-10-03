package com.epam.coffeewagon.wagon;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.coffee.condition.Condition;
import com.epam.coffeewagon.garage.Garage;
import com.epam.coffeewagon.main.Main;
import com.epam.coffeewagon.store.StoreService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WagonService implements WagonServiceInterface {

    public Double getCurrentCapacityOfCargoInWagon(String name) {
        printLoggerToGettingCapacity();
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

    private void printLoggerToGettingCapacity() {
        new Main().getLogger().info("Started method 'getCurrentCapacityOfCargoInWagon' " +
                "with argument 'name'");
    }

    public Double getCurrentWeightOfCargoInWagon(String name) {
        printLoggerToGettingWeight();
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

    private void printLoggerToGettingWeight() {
        new Main().getLogger().info("Started method 'getCurrentWeightOfCargoInWagon' " +
                "with argument 'name'");
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

    private void printLoggerToGettingPrice() {
        new Main().getLogger().info("Started method 'getCurrentPriceOfCargoInWagon' " +
                "with argument 'name'");
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
        new Main().getLogger().info("Started method 'addCoffeeToWagon' " +
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
        new Main().getLogger().info("Started method 'addCoffeeToWagonManually' " +
                "with arguments 'wagonName', 'coffeeName' and 'condition'");
    }

    public void removeCoffeeFromWagon(String wagonName, Coffee coffee) {
        printLoggerToRemoveCoffeeFromWagon();
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

    private void printLoggerToRemoveCoffeeFromWagon() {
        new Main().getLogger().info("Started method 'removeCoffeeFromWagon' " +
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

    private void printLoggerToGettingListOfCoffeeInWagon(){
        new Main().getLogger().info("Started method 'removeCoffeeFromWagon' " +
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

        while (findCheepCoffeeInStore().getPrice() < getCurrentPriceOfCargoInWagon(wagonName)) {
            addCoffeeToWagon(wagonName, findCheepCoffeeInStore());
        }
        System.out.println("Free price : " + getCurrentPriceOfCargoInWagon(wagonName) + "\n" +
                "Free wright : " + getCurrentWeightOfCargoInWagon(wagonName) + "\n" +
                "Free capacity : " + getCurrentCapacityOfCargoInWagon(wagonName));
    }

    private void printLoggerToAddingCoffeeToWagonAutomatically() {
        new Main().getLogger().info("Started method 'addCoffeeToWagonAutomatically' " +
                "with arguments 'wagonName' and 'maxPriceInWagon'");
    }

    private void addCoffeeAfterCheckingPrice(String wagonName, Coffee coffee, double maxPriceInWagon){
        printLoggerToAddingCoffeeAfterCheckingPrice();
        int price = (int) maxPriceInWagon / 3;
        for (int i = 0; i < price / coffee.getPrice(); i++) {
            if (coffee.getPrice() < getCurrentPriceOfCargoInWagon(wagonName)) {
                addCoffeeToWagon(wagonName, coffee);
            }
        }
    }

    private void printLoggerToAddingCoffeeAfterCheckingPrice() {
        new Main().getLogger().info("Started method 'addCoffeeAfterCheckingPrice' " +
                "with arguments 'wagonName', 'coffee' and 'maxPriceInWagon'");
    }

    public Coffee findCheepCoffeeInStore() {
        Coffee cheepCoffee;
        List<Coffee> sortedList = sortByName(new StoreService().getListOfCoffeeInStore());
        cheepCoffee = sortedList.get(0);
        return cheepCoffee;
    }

    private void printLoggerToFindingCheepCoffeeInStore() {
        new Main().getLogger().info("Started method 'findCheepCoffeeInStore' " +
                "without arguments");
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
