package com.epam.coffeewagon.main;

import java.io.IOException;

public class Greeting {

    public void greet() {
        System.out.println("Hello");
        System.out.println("There is a store with coffee.\n" +
                "We should create new wagon.\n" +
                "Then we'll load our wagon with coffee.\n" +
                "We can sort list of coffee we loaded in wagon.");
        System.out.println("Let's start.");
    }

    public String chooseWagonName() throws IOException {
        String name = "";
        int count = 0;
        while (name.equals("")) {
            name = new Communicator().getStringFromBufferedReader();
            count++;
            if (count > 2) {
                System.out.println("The name of your wagon will be 'Wally' ");
                name = "Wally";
            }
        }
        return name;
    }

    public Double chooseMaxPriceOfCargoInWagon() throws IOException {
        double maxPrice = 0.0;
        int count = 0;
        while (maxPrice == 0.0) {
            maxPrice = new Communicator().getDoubleFromBufferedReader();
            count++;
            if (count > 2) {
                System.out.println("MaxPrice of your cargo will be 500. ");
                maxPrice = 500;
            }
        }
        return maxPrice;
    }
}
