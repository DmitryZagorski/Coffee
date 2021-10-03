package com.epam.coffeewagon.main;

import com.epam.coffeewagon.garage.GarageService;
import com.epam.coffeewagon.garage.GarageServiceInterface;
import com.epam.coffeewagon.store.StoreInterface;
import com.epam.coffeewagon.store.StoreService;
import com.epam.coffeewagon.wagon.WagonService;
import com.epam.coffeewagon.wagon.WagonServiceInterface;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());

    public Logger getLogger(){
        return LOGGER;
    }

    public static void main(String[] args) throws IOException {

        LOGGER.info("Method main is started");

        GarageServiceInterface garageServiceInterface = new GarageService();

        WagonServiceInterface wagonServiceInterface = new WagonService();

        WagonService wagonService = new WagonService();

        StoreInterface storeInterface = new StoreService();

        Greeting greeting = new Greeting();
        Loading loading = new Loading(wagonServiceInterface);
        Sorting sorting = new Sorting(wagonService);

        greeting.greet();
        System.out.println("Enter the name of wagon:");
        String name = greeting.chooseWagonName();
        System.out.println("Enter the max price of cargo in wagon:");
        Double maxPrice = greeting.chooseMaxPriceOfCargoInWagon();
        garageServiceInterface.addWagon(name, maxPrice);

        loading.viewListOfCoffeeInStore(storeInterface.getListOfCoffeeInStore());
        loading.loadWagon(name, maxPrice);

        sorting.sortCargos(wagonServiceInterface.getListOfCoffeeInWagon(name));

        System.out.println("This is the end.");
        System.out.println("You can push the button 'Run main' to retry...");

        LOGGER.info("Method main is ended");

    }
}
