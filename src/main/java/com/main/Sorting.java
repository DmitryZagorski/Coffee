package com.main;

import com.coffee.Coffee;
import com.wagon.WagonService;
import com.wagon.WagonServiceInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Sorting {

    public void sortingOfCargoListInWagon(List<Coffee> list) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Now we can sort our list of coffee in wagon");
        System.out.println("Press '1' if you want to sort it by name.\n" +
                "Press '2' if you want to sort it by price.\n" +
                "Press '3' if you want to sort it by weight.\n" +
                "Press '4' if you want to sort it by priceToWeight.\n" +
                "Press '5' if you want to sort it by name then by price.");
        String choose = reader.readLine();
        if (choose.equals("1")){
            new WagonService().sortByName(list);
            for (Coffee coffee : list) {
                System.out.println(coffee.toString());
            }
        }
        if (choose.equals("2")){
            new WagonService().sortByPrice(list);
            for (Coffee coffee : list) {
                System.out.println(coffee.toString());
            }
        }
        if (choose.equals("3")){
            new WagonService().sortByWeight(list);
            for (Coffee coffee : list) {
                System.out.println(coffee.toString());
            }
        }
        if (choose.equals("4")){
            new WagonService().sortByPriceToWeight(list);
            for (Coffee coffee : list) {
                System.out.println(coffee.toString());
            }
        }
        if (choose.equals("5")){
            new WagonService().sortByNameThenByPrice(list);
            for (Coffee coffee : list) {
                System.out.println(coffee.toString());
            }
        }
    }

}
