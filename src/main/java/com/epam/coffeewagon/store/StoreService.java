package com.epam.coffeewagon.store;

import com.epam.coffeewagon.coffee.Coffee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StoreService implements StoreInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(StoreService.class.getSimpleName());

    List<Coffee> listOfCoffeeInStore;

    {
        listOfCoffeeInStore = new StoreFileService().readFirstConditionOfStore();
    }

    public List<Coffee> getListOfCoffeeInStore() {
        return listOfCoffeeInStore;
    }

    public void addCoffeeToStore(Coffee coffee) {
        if (coffee.getCapacity() > 0 && coffee.getPrice() > 0 && coffee.getWeight() > 0) {
            listOfCoffeeInStore.add(coffee);
        }
    }

    public void removeCoffeeFromStore(Coffee coffee) {
        printLoggerToRemoveCoffeeFromStore();
        for (int i = 0; i < getListOfCoffeeInStore().size(); i++) {
            if (coffee.getName().equals(getListOfCoffeeInStore().get(i).getName()) &&
                    coffee.getPrice() == getListOfCoffeeInStore().get(i).getPrice() &&
                    coffee.getCapacity() == getListOfCoffeeInStore().get(i).getCapacity()) {
                getListOfCoffeeInStore().remove(getListOfCoffeeInStore().get(i));
            } else if (coffee.getName().equals(getListOfCoffeeInStore().get(i).getName()) &&
                    coffee.getCapacity() < getListOfCoffeeInStore().get(i).getCapacity()) {
                getListOfCoffeeInStore().get(i).setCapacity(getListOfCoffeeInStore().get(i).getCapacity() -
                        coffee.getCapacity());
            }
        }
    }

    private void printLoggerToRemoveCoffeeFromStore() {
        LOGGER.info("Started method 'removeCoffeeFromStore' " +
                "with argument 'Coffee'");
    }
}
