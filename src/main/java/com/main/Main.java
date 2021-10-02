package com.main;

import com.garage.GarageService;
import com.garage.GarageServiceInterface;
import com.store.StoreInterface;
import com.store.StoreService;
import com.wagon.WagonService;
import com.wagon.WagonServiceInterface;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        GarageServiceInterface garageServiceInterface = new GarageService();

        WagonServiceInterface wagonServiceInterface = new WagonService();

        StoreInterface storeInterface = new StoreService();

        Greeting greeting = new Greeting();
        Loading loading = new Loading();
        Sorting sorting = new Sorting();

        greeting.greeting();
        System.out.println("Enter the name of wagon:");
        String name = greeting.choiceOfWagonName();
        System.out.println("Enter the max price of cargo in wagon:");
        Double maxPrice = greeting.choiceOfMaxPriceOfCargoInWagon();
        garageServiceInterface.addWagon(name, maxPrice);

        loading.viewListOfCoffeeInStore(storeInterface.getListOfCoffeeInStore());
        loading.loadingOfWagon(name, maxPrice);

        sorting.sortingOfCargoListInWagon(wagonServiceInterface.getListOfCoffeeInWagon(name));

        System.out.println("This is the end.");
        System.out.println("You can push the button 'Run main' to retry...");

    }
}
