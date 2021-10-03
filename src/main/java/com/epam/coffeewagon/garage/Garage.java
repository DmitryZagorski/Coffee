package com.garage;

import com.wagon.Wagon;

import java.util.ArrayList;
import java.util.List;

public class Garage{

    private String name;
    private static List<Wagon> listOfWagon = new ArrayList<>();

    public Garage() {
    }

    public Garage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Wagon> getListOfWagon() {
        return listOfWagon;
    }

}
