package com.main;

import com.coffee.Coffee;
import com.coffee.condition.Condition;
import com.wagon.WagonService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Loading {

    public Loading() {
    }

    public void viewListOfCoffeeInStore(List<Coffee> list) {
        System.out.println("It's the list of coffee in the store.");
        for (Coffee coffee : list) {
            System.out.println(coffee.toString());
        }
    }

    public void loadingOfWagon(String wagonName, Double maxPrice) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Now you can load the wagon with coffee.\n" +
                "It's price shouldn't be more than max price of cargo in wagon.\n" +
                "Press '1' if you want to load the wagon automatically.\n" +
                "Press '2' if you want to load the wagon independently.");
        String digit = reader.readLine();
        while (true) {
            if (digit.equals("1")) {
                new WagonService().addCoffeeToWagonAutomatically(wagonName, maxPrice);
                System.out.println("List of coffee in wagon: ");
                for (Coffee coffee : new WagonService().getListOfCoffeeInWagon(wagonName)) {
                    System.out.println(coffee.toString());
                }
                break;
            }
            if (digit.equals("2")) {
                System.out.println("Press '1' to add the coffee.\n" +
                        "Press '2' to STOP.");
                String a = reader.readLine();
                if (a.equals("1")) {
                    new WagonService().addCoffeeToWagonManually(wagonName, addManuallyQuestionWhatName(), addManuallyQuestionWhatCondition());
                }
                if (a.equals("2")) {
                    System.out.println("List of coffee in wagon: ");
                    for (Coffee coffee : new WagonService().getListOfCoffeeInWagon(wagonName)) {
                        System.out.println(coffee.toString());
                    }
                    break;
                }
            }
        }
    }

    public String addManuallyQuestionWhatName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String coffeeName = null;
        System.out.println("What name of coffee?\n" +
                "Press '1' if 'Barista'\n" +
                "Press '2' if 'Dallmayr'\n" +
                "Press '3' if 'Lavazza'");
        String name = reader.readLine();
        if (name.equals("1")) {
            coffeeName = "Barista";
        }
        if (name.equals("2")) {
            coffeeName = "Dallmayr";
        }
        if (name.equals("3")) {
            coffeeName = "Lavazza";
        }
        return coffeeName;
    }

    public Condition addManuallyQuestionWhatCondition() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What condition of coffee?\n" +
                "Press '1' if 'BeansCoffee'\n" +
                "Press '2' if 'GroundCoffee'\n" +
                "Press '3' if 'InstantCoffeeInBags'\n" +
                "Press '4' if 'InstantCoffeeInCans'");
        String condition = reader.readLine();
        if (condition.equals("1")) {
            return Condition.BEANS;
        }
        if (condition.equals("2")) {
            return Condition.GROUND;
        }
        if (condition.equals("3")) {
            return Condition.INSTANT_BAGS;
        }
        if (condition.equals("4")) {
            return Condition.INSTANT_CANS;
        } else return null;
    }

}
