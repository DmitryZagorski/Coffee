package com.epam.coffeewagon.main;

import com.epam.coffeewagon.coffee.Coffee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sorting.class.getSimpleName());

    public void sortCargos(List<Coffee> list) {
        LOGGER.info("Start of sorting coffee in wagon");
        printSortingMessage();
        sortItems(list);
        printItems(list);
    }

    private void printSortingMessage() {
        System.out.println(
                "Now we can sort our list of coffee in wagon. \n" +
                        "Press '1' if you want to sort it by name.\n" +
                        "Press '2' if you want to sort it by price.\n" +
                        "Press '3' if you want to sort it by weight.\n" +
                        "Press '4' if you want to sort it by priceToWeight.\n" +
                        "Press '5' if you want to sort it by name then by price.");
    }

    private void sortItems(List<Coffee> list) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            switch (reader.readLine()) {
                case "1":
                    sortByName(list);
                    break;
                case "2":
                    sortByPrice(list);
                    break;
                case "3":
                    sortByWeight(list);
                    break;
                case "4":
                    sortByPriceToWeight(list);
                    break;
                case "5":
                    sortByNameThenByPrice(list);
                    break;
                default:
                    System.err.println("Incorrect number, try again");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printItems(List<Coffee> list) {
        list.forEach(System.out::println);
    }

    public List<Coffee> sortByName(List<Coffee> list) {
        list.sort(Comparator.comparing(Coffee::getName));
        return list;
    }

    public List<Coffee> sortByPrice(List<Coffee> list) {
        list.sort(Comparator.comparing(Coffee::getPrice));
        return list;
    }

    public List<Coffee> sortByWeight(List<Coffee> list) {
        list.sort(Comparator.comparing(Coffee::getWeight));
        return list;
    }

    public List<Coffee> sortByPriceToWeight(List<Coffee> list) {
        list.sort(Comparator.comparing(Coffee::getPriceToWeight));
        return list;
    }

    public List<Coffee> sortByNameThenByPrice(List<Coffee> list) {
        list.sort(Comparator.comparing(Coffee::getName).thenComparing(Coffee::getPrice));
        return list;
    }
}
