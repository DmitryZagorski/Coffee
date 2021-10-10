package com.epam.coffeewagon.main;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.coffee.condition.Condition;
import com.epam.coffeewagon.wagon.WagonServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
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

    public void loadWagon(String wagonName, Double maxPrice) throws IOException {
        LOGGER.info("Starting of loading wagon named '{}' and with max price of cargo '{}'.", wagonName, maxPrice);
        printInfoBeforeLoadWagon();
        int count = 0;
        String choice = "";
        while (choice.equals("")) {
            choice = new Communicator().getStringFromBufferedReader();
            if (choice.equals("1")) {
                wagonServiceInterface.addCoffeeToWagonAutomatically(wagonName, maxPrice);
                System.out.println("List of coffee in wagon: ");
                for (Coffee coffee : wagonServiceInterface.getListOfCoffeeInWagon(wagonName)) {
                    System.out.println(coffee.toString());
                }
                break;
            }
            if (choice.equals("2")) {
                loadManuallyInCase2(wagonName);
                break;
            }
            if (count > 2) {
                LOGGER.info("Wagon will be loaded automatically.");
                wagonServiceInterface.addCoffeeToWagonAutomatically(wagonName, maxPrice);
                break;
            } else {
                System.err.println("Incorrect number. Try again.");
                count++;
                choice = "";
            }
        }
    }

    private void loadManuallyInCase2(String wagonName) throws IOException {
        System.out.println("Press '1' to add the coffee.\n" +
                           "Press '2' to STOP.");
        String newString = "";
        int count = 0;
        while (newString.equals("")) {
            newString = new Communicator().getStringFromBufferedReader();
            if (newString.equals("1")) {
                wagonServiceInterface.addCoffeeToWagonManually(wagonName, chooseNameOfLoadingCoffee(), chooseConditionOfLoadingCoffee());
                loadManuallyInCase2(wagonName);
                break;
            }
            if (newString.equals("2")) {
                System.out.println("List of coffee in wagon: ");
                for (Coffee coffee : wagonServiceInterface.getListOfCoffeeInWagon(wagonName)) {
                    System.out.println(coffee.toString());
                }
                break;
            }
            if (count > 2) {
                System.out.println("Variant 'STOP' was chosen automatically.");
                System.out.println("List of coffee in wagon: ");
                for (Coffee coffee : wagonServiceInterface.getListOfCoffeeInWagon(wagonName)) {
                    System.out.println(coffee.toString());
                }
                break;
            } else {
                System.err.println("Incorrect number. Try again.");
                count++;
                newString = "";
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
        String name = "";
        String coffeeName = "";
        int count = 0;
        while (name.equals("")) {
            name = new Communicator().getStringFromBufferedReader();
            if (name.equals("1")) {
                coffeeName = "Barista";
                break;
            }
            if (name.equals("2")) {
                coffeeName = "Dallmayr";
                break;
            }
            if (name.equals("3")) {
                coffeeName = "Lavazza";
                break;
            }
            if (count > 2) {
                System.out.println("Name 'Barista' was chosen automatically.");
                coffeeName = "Barista";
                break;
            } else {
                count++;
                System.out.println("Something wrong. Try again!");
            }
        }
        return coffeeName;
    }

    public void askNameOfLoadingCoffee() {
        System.out.println("What name of coffee?\n" +
                "Press '1' if 'Barista'\n" +
                "Press '2' if 'Dallmayr'\n" +
                "Press '3' if 'Lavazza'");
    }

    public Condition chooseConditionOfLoadingCoffee() throws IOException {
        LOGGER.info("Start of choosing one of four conditions of coffee.");
        askConditionOfLoadingCoffee();
        Condition condition = null;
        int count = 0;
        String choice = "";
        while (choice.equals("")) {
            choice = new Communicator().getStringFromBufferedReader();
            if (choice.equals("1")) {
                condition = Condition.BEANS;
                break;
            }
            if (choice.equals("2")) {
                condition = Condition.GROUND;
                break;
            }
            if (choice.equals("3")) {
                condition = Condition.INSTANT_BAGS;
                break;
            }
            if (choice.equals("4")) {
                condition = Condition.INSTANT_CANS;
                break;
            }
            if (count > 2) {
                System.out.println("Condition 'BeansCoffee' was chosen automatically.");
                condition = Condition.BEANS;
                break;
            } else {
                System.err.println("Incorrect number. Try again.");
                count++;
            }
        }
        return condition;
    }

    public void askConditionOfLoadingCoffee() {
        System.out.println("What condition of coffee?\n" +
                "Press '1' if 'BeansCoffee'\n" +
                "Press '2' if 'GroundCoffee'\n" +
                "Press '3' if 'InstantCoffeeInBags'\n" +
                "Press '4' if 'InstantCoffeeInCans'");
    }
}
