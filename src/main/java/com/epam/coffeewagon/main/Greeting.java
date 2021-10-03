package com.main;

import com.store.StoreFileInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greeting {

    public Greeting() {
    }

    public void greet(){
        System.out.println("Hello");
        System.out.println("There is a store with coffee.\n" +
                "We should create new wagon.\n" +
                "Then we'll load our wagon with coffee.\n" +
                "We can sort list of coffee we loaded in wagon.");
        System.out.println("Let's start.");
    }

    public String choiceOfWagonName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public Double choiceOfMaxPriceOfCargoInWagon() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(reader.readLine());
    }
}
