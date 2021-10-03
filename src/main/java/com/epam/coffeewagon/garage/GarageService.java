package com.epam.coffeewagon.garage;

import com.epam.coffeewagon.wagon.Wagon;
import org.apache.log4j.Logger;

import static com.epam.coffeewagon.garage.Garage.getListOfWagon;

public class GarageService implements GarageServiceInterface {

    private static final Logger LOGGER = Logger.getLogger(GarageService.class.getSimpleName());

    public void addWagon(String name, Double maxPriceOfCargo) {
        printLoggerToAddWagon();
        getListOfWagon().add(new Wagon(name, maxPriceOfCargo));
    }

    private void printLoggerToAddWagon() {
        LOGGER.info("Started method 'addWagon', " +
                "with arguments 'name' and 'maxPriceOfCargo', " +
                "which should add new wagon to listOfWagon.");
    }
}
