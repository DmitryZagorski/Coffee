package com.epam.coffeewagon.store;

import com.epam.coffeewagon.coffee.Coffee;
import com.epam.coffeewagon.coffee.condition.Condition;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StoreFileService implements StoreFileInterface {

    Gson gson = new Gson();

    private static final Logger LOGGER = LoggerFactory.getLogger(StoreFileService.class.getSimpleName());

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

        String shopsToJson = gson.toJson(startCoffeeConditionList);
        try (FileWriter writer = new FileWriter(new File(FIRST_CONDITION_COFFEE_IN_STORE))) {
            writer.write(shopsToJson);
        } catch (IOException e) {
            printIOExceptionLoggerConditionOfStore();
            throw new IllegalStateException(e);
        }
    }

    private void printLoggerToWriteConditionOfStore() {
        LOGGER.info("Starting of writing First Condition Of Store");
    }

    private void printIOExceptionLoggerConditionOfStore() {
        LOGGER.error("We can get an exception, " +
                "if file won't be found");
    }

    public List<Coffee> readFirstConditionOfStore() {
        printLoggerToReadConditionOfStore();
        List<Coffee> firstConditionalList = new ArrayList<>();

        try (JsonReader jsonReader = new JsonReader(new FileReader(FIRST_CONDITION_COFFEE_IN_STORE))) {
            Type type = new TypeToken<List<Coffee>>() {
            }.getType();
            return gson.fromJson(jsonReader, type);
        } catch (IOException e) {
            printIOExceptionLoggerConditionOfStore();
            throw new IllegalStateException();
        }
    }

    private void printLoggerToReadConditionOfStore() {
        LOGGER.info("Started method 'readFirstConditionOfStore'.");
    }

}
