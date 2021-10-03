package com.epam.coffeewagon.store;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.coffee.condition.Condition;
import com.epam.coffeewagon.garage.GarageService;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StoreFileService implements StoreFileInterface {

    private static final Logger LOGGER = Logger.getLogger(GarageService.class.getSimpleName());

    private static final String FIRST_CONDITION_COFFEE_IN_STORE = "D:/java/Coffee/src/main/java/com/epam/coffeewagon/store/FirstCoffeeListInStore.txt";

    List<Coffee> startCoffeeConditionList = new ArrayList<>();

    {
        startCoffeeConditionList.add(new Coffee("Barista", Condition.BEANS, 1.0, 2.0, 10.0));
        startCoffeeConditionList.add(new Coffee("Barista", Condition.GROUND, 0.5, 1.0, 15.0));
        startCoffeeConditionList.add(new Coffee("Barista", Condition.INSTANT_BAGS, 0.5, 2.0, 25.0));
        startCoffeeConditionList.add(new Coffee("Barista", Condition.INSTANT_CANS, 1.0, 1.0, 20.0));
        startCoffeeConditionList.add(new Coffee("Dallmayr", Condition.BEANS, 1.0, 2.0, 12.0));
        startCoffeeConditionList.add(new Coffee("Dallmayr", Condition.GROUND, 0.5, 1.0, 17.0));
        startCoffeeConditionList.add(new Coffee("Dallmayr", Condition.INSTANT_BAGS, 0.5, 2.0, 27.0));
        startCoffeeConditionList.add(new Coffee("Dallmayr", Condition.INSTANT_CANS, 1.0, 1.0, 22.0));
        startCoffeeConditionList.add(new Coffee("Lavazza", Condition.BEANS, 1.0, 2.0, 20.0));
        startCoffeeConditionList.add(new Coffee("Lavazza", Condition.GROUND, 0.5, 1.0, 30.0));
        startCoffeeConditionList.add(new Coffee("Lavazza", Condition.INSTANT_BAGS, 0.5, 2.0, 40.0));
        startCoffeeConditionList.add(new Coffee("Lavazza", Condition.INSTANT_CANS, 1.0, 1.0, 35.0));

    }

    public void writeFirstConditionOfStore() {
        printLoggerToWriteConditionOfStore();
        try (FileOutputStream fos = new FileOutputStream(FIRST_CONDITION_COFFEE_IN_STORE);
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(startCoffeeConditionList);
        } catch (IOException e) {
            printIOExceptionLoggerConditionOfStore();
            e.printStackTrace();
        }
    }

    private void printLoggerToWriteConditionOfStore() {
        LOGGER.info("Started method 'writeFirstConditionOfStore'");
    }

    private void printIOExceptionLoggerConditionOfStore() {
        LOGGER.error("We can get an exception, " +
                "if file won't be found");
    }

    public List<Coffee> readFirstConditionOfStore() {
        printLoggerToReadConditionOfStore();
        List<Coffee> firstConditionalList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(FIRST_CONDITION_COFFEE_IN_STORE);
             ObjectInputStream ois = new ObjectInputStream(fis);) {
            firstConditionalList = (List<Coffee>) ois.readObject();
        } catch (IOException e) {
            printIOExceptionLoggerConditionOfStore();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            printNotFountExceptionLoggerToReadConditionOfStore();
            e.printStackTrace();
        }
        return firstConditionalList;
    }

    private void printLoggerToReadConditionOfStore() {
        LOGGER.info("Started method 'readFirstConditionOfStore'.");
    }

    private void printNotFountExceptionLoggerToReadConditionOfStore() {
        LOGGER.error("We can get an exception, " +
                "if the class of our objects won't be found.");
    }
}
