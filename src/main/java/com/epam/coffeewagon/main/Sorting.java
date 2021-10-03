package com.epam.coffeewagon.main;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.wagon.WagonService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Sorting {

    private WagonService wagonService;

    public Sorting(WagonService wagonService) {
        this.wagonService = wagonService;
    }

    public void sortCargos(List<Coffee> list) throws IOException {
        printLoggerToSortCargo();
        printSortingMessage();
        sortItems(list);
        printItems(list);
    }

    private void printLoggerToSortCargo(){
        new Main().getLogger().info("" +
                "Started method 'sortCargos' with argument 'List<Coffee>'");
    }

    private void printSortingMessage() {
        System.out.println(
                "Now we can sort our list of coffee in wagon. \n" +
                        "Press '1' if you want to sort it by name.\n" +
                        "Press '2' if you want to sort it by price.\n" +
                        "Press '3' if you want to sort it by weight.\n" +
                        "Press '4' if you want to sort it by priceToWeight.\n" +
                        "Press '5' if you want to sort it by name then by price."
        );
    }

    private void sortItems(List<Coffee> list) throws IOException {
        printLoggerToSortItems();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            switch (reader.readLine()) {
                case "1":
                    wagonService.sortByName(list);
                    break;
                case "2":
                    wagonService.sortByPrice(list);
                    break;
                case "3":
                    wagonService.sortByWeight(list);
                    break;
                case "4":
                    wagonService.sortByPriceToWeight(list);
                    break;
                case "5":
                    wagonService.sortByNameThenByPrice(list);
                    break;
                default:
                    System.err.println("Incorrect number, try again");
            }
        }
    }

    private void printLoggerToSortItems(){
        new Main().getLogger().info("" +
                "Started method 'sortItems' " +
                "with argument 'List<Coffee>', where we should " +
                "choose one of five variants of sorting our coffeeList");
    }

    private void printItems(List<Coffee> list) {
        list.forEach(System.out::println);
    }

}
