package com.epam.coffeewagon.main;

import com.epam.coffeewagon.garage.GarageService;
import com.epam.coffeewagon.garage.GarageServiceInterface;
import com.epam.coffeewagon.store.StoreFileInterface;
import com.epam.coffeewagon.store.StoreFileService;
import com.epam.coffeewagon.store.StoreInterface;
import com.epam.coffeewagon.store.StoreService;
import com.epam.coffeewagon.wagon.WagonService;
import com.epam.coffeewagon.wagon.WagonServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) throws IOException {

        LOGGER.info("Our program is started");

        StoreFileInterface storeFileInterface = new StoreFileService();

        storeFileInterface.writeFirstConditionOfStore();

        GarageServiceInterface garageServiceInterface = new GarageService();

        WagonServiceInterface wagonServiceInterface = new WagonService();

        StoreInterface storeInterface = new StoreService();

        Greeting greeting = new Greeting();
        Loading loading = new Loading(wagonServiceInterface);
        Sorting sorting = new Sorting();

        greeting.greet();
        System.out.println("Enter the name of wagon. (You can try 3 times)");
        String name = greeting.chooseWagonName();
        System.out.println("Enter the max price of cargo in wagon: (You can try 3 times)");
        Double maxPrice = greeting.chooseMaxPriceOfCargoInWagon();
        garageServiceInterface.addWagon(name, maxPrice);

        loading.viewListOfCoffeeInStore(storeInterface.getListOfCoffeeInStore());
        loading.loadWagon(name, maxPrice);

        sorting.sortCargos(wagonServiceInterface.getListOfCoffeeInWagon(name));

        System.out.println("This is the end.");
        System.out.println("You can push the button 'Run main' to retry...");

        LOGGER.info("Our program is ended");
    }
}
