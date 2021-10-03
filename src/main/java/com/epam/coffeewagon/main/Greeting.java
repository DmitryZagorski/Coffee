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
        return new Communicator().getStringFromBufferedReader();
    }

    public Double chooseMaxPriceOfCargoInWagon() throws IOException {
        return new Communicator().getDoubleFromBufferedReader();
    }
}
