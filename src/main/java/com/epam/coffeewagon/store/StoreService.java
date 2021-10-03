package com.epam.coffeewagon.store;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.main.Main;

import java.util.List;

public class StoreService implements StoreInterface{

    List<Coffee> listOfCoffeeInStore;

    {
        listOfCoffeeInStore = new StoreFileService().readFirstConditionOfStore();
    }

    public List<Coffee> getListOfCoffeeInStore(){
        return listOfCoffeeInStore;
    }


    public List<Coffee> addCoffeeToStore(Coffee coffee){
        if (coffee.getCapacity()>0 && coffee.getPrice()>0 && coffee.getWeight()>0){
            listOfCoffeeInStore.add(coffee);
        }
        return listOfCoffeeInStore;
    }

    public List<Coffee> removeCoffeeFromStore(Coffee coffee){
        printLoggerToRemoveCoffeeFromStore();
        if (listOfCoffeeInStore.contains(coffee)) {
            for (Coffee storeCoffee : listOfCoffeeInStore) {
                if (coffee.getName().equals(storeCoffee.getName()) &&
                        coffee.getCapacity() == storeCoffee.getCapacity()) {
                    listOfCoffeeInStore.remove(coffee);
                }
                else if (coffee.getName().equals(storeCoffee.getName()) &&
                        coffee.getCapacity() < storeCoffee.getCapacity()){
                    storeCoffee.setCapacity(storeCoffee.getCapacity()-
                            coffee.getCapacity());
                }
                else System.out.println("Wrong data");
            }
        }
        return listOfCoffeeInStore;
    }

    private void printLoggerToRemoveCoffeeFromStore(){
        new Main().getLogger().info("Started method 'removeCoffeeFromStore' " +
                "with argument 'Coffee'");
    }
}
