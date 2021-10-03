package com.epam.coffeewagon.garage;

import com.epam.coffeewagon.main.Main;
import com.epam.coffeewagon.wagon.Wagon;

import static com.epam.coffeewagon.garage.Garage.getListOfWagon;

public class GarageService implements GarageServiceInterface {

    public void addWagon(String name, Double maxPriceOfCargo) {
        new Main().getLogger().info(
                "Method 'addWagon', " +
                        "with arguments 'name' and 'maxPriceOfCargo', " +
                        "which should add new wagon to listOfWagon started."
        );
        getListOfWagon().add(new Wagon(name, maxPriceOfCargo));
    }
}
