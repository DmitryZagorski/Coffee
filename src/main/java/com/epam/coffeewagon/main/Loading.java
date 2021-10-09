package com.epam.coffeewagon.main;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.coffee.condition.Condition;
import com.epam.coffeewagon.wagon.WagonServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Loading {

    private static final Logger LOGGER = LoggerFactory.getLogger(Loading.class.getSimpleName());

    private WagonServiceInterface wagonServiceInterface;

    public Loading(WagonServiceInterface wagonServiceInterface) {
        this.wagonServiceInterface = wagonServiceInterface;
    }

    public void viewListOfCoffeeInStore(List<Coffee> list) {
        System.out.println("It's the list of coffee in the store.");
        for (Coffee coffee : list) {
            System.out.println(coffee.toString());
        }
    }

    public void loadWagon(String wagonName, Double maxPrice) {
        LOGGER.info("Starting of loading wagon named '{}' and with max price of cargo '{}'.", wagonName, maxPrice);
        printInfoBeforeLoadWagon();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            {
                switch (reader.readLine()) {
                    case "1":
                        wagonServiceInterface.addCoffeeToWagonAutomatically(wagonName, maxPrice);
                        System.out.println("List of coffee in wagon: ");
                        for (Coffee coffee : wagonServiceInterface.getListOfCoffeeInWagon(wagonName)) {
                            System.out.println(coffee.toString());
                        }
                        break;
                    case "2":
                        loadManuallyInCase2(wagonName);
                        break;
                    default:
                        System.err.println("Incorrect number. Try again.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadManuallyInCase2(String wagonName) throws IOException {
        System.out.println("Press '1' to add the coffee.\n" +
                "Press '2' to STOP.");
        String newString = new Communicator().getStringFromBufferedReader();
        if (newString.equals("1")) {
            wagonServiceInterface.addCoffeeToWagonManually(wagonName, chooseNameOfLoadingCoffee(), chooseConditionOfLoadingCoffee());
            loadManuallyInCase2(wagonName);
        }
        if (newString.equals("2")) {
            System.out.println("List of coffee in wagon: ");
            for (Coffee coffee : wagonServiceInterface.getListOfCoffeeInWagon(wagonName)) {
                System.out.println(coffee.toString());
            }
        }
    }

    public void printInfoBeforeLoadWagon() {
        System.out.println("Now you can load the wagon with coffee.\n" +
                "It's price shouldn't be more than max price of cargo in wagon.\n" +
                "Press '1' if you want to load the wagon automatically.\n" +
                "Press '2' if you want to load the wagon independently.");
    }

    public String chooseNameOfLoadingCoffee() throws IOException {
        LOGGER.info("Start of choosing one of three names of coffee.");
        askNameOfLoadingCoffee();
        String coffeeName = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            coffeeName = null;
            String name = reader.readLine();
            if (name.equals("1")) {
                coffeeName = "Barista";
            }
            if (name.equals("2")) {
                coffeeName = "Dallmayr";
            }
            if (name.equals("3")) {
                coffeeName = "Lavazza";
            } else {
                System.out.println("Something wrong. Try again!");
                chooseNameOfLoadingCoffee();
            }
            return coffeeName;
        } catch (IOException e) {
            e.printStackTrace();
            return coffeeName;
        }
    }

    public void askNameOfLoadingCoffee() {
        System.out.println("What name of coffee?\n" +
                "Press '1' if 'Barista'\n" +
                "Press '2' if 'Dallmayr'\n" +
                "Press '3' if 'Lavazza'");
    }

    public Condition chooseConditionOfLoadingCoffee() {
        LOGGER.info("Start of choosing one of four conditions of coffee.");
        askConditionOfLoadingCoffee();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            switch (reader.readLine()) {
                case "1":
                    return Condition.BEANS;
                case "2":
                    return Condition.GROUND;
                case "3":
                    return Condition.INSTANT_BAGS;
                case "4":
                    return Condition.INSTANT_CANS;
                default:
                    System.err.println("Incorrect number. Try again.");
                    chooseConditionOfLoadingCoffee();
                    return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void askConditionOfLoadingCoffee() {
        System.out.println("What condition of coffee?\n" +
                "Press '1' if 'BeansCoffee'\n" +
                "Press '2' if 'GroundCoffee'\n" +
                "Press '3' if 'InstantCoffeeInBags'\n" +
                "Press '4' if 'InstantCoffeeInCans'");
    }
}
