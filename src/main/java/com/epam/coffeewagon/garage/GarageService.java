package com.epam.coffeewagon.garage;

import com.epam.coffeewagon.wagon.Wagon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.epam.coffeewagon.garage.Garage.getListOfWagon;

public class GarageService implements GarageServiceInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(GarageService.class.getSimpleName());

    public void addWagon(String name, Double maxPriceOfCargo) {
        LOGGER.info("Starting of adding new wagon by name as {} and with maximal price of cargo equals {} .", name, maxPriceOfCargo );
        getListOfWagon().add(new Wagon(name, maxPriceOfCargo));
    }

}
