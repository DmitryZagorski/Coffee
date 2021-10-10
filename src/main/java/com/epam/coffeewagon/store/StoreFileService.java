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

    private static final String FIRST_CONDITION_COFFEE_IN_STORE = "FirstCoffeeListInStore.json";

    List<Coffee> startCoffeeConditionList = new ArrayList<>();

    {
        startCoffeeConditionList.add(new Coffee("Barista", Condition.BEANS, 1.0, 0.1, 10.0));
        startCoffeeConditionList.add(new Coffee("Barista", Condition.GROUND, 0.5, 0.1, 15.0));
        startCoffeeConditionList.add(new Coffee("Barista", Condition.INSTANT_BAGS, 0.5, 0.2, 25.0));
        startCoffeeConditionList.add(new Coffee("Barista", Condition.INSTANT_CANS, 1.0, 0.2, 20.0));
        startCoffeeConditionList.add(new Coffee("Dallmayr", Condition.BEANS, 1.0, 0.1, 12.0));
        startCoffeeConditionList.add(new Coffee("Dallmayr", Condition.GROUND, 0.5, 0.1, 17.0));
        startCoffeeConditionList.add(new Coffee("Dallmayr", Condition.INSTANT_BAGS, 0.5, 0.2, 27.0));
        startCoffeeConditionList.add(new Coffee("Dallmayr", Condition.INSTANT_CANS, 1.0, 0.2, 22.0));
        startCoffeeConditionList.add(new Coffee("Lavazza", Condition.BEANS, 1.0, 0.1, 20.0));
        startCoffeeConditionList.add(new Coffee("Lavazza", Condition.GROUND, 0.5, 0.1, 30.0));
        startCoffeeConditionList.add(new Coffee("Lavazza", Condition.INSTANT_BAGS, 0.5, 0.2, 40.0));
        startCoffeeConditionList.add(new Coffee("Lavazza", Condition.INSTANT_CANS, 1.0, 0.2, 35.0));

    }

    public void writeFirstConditionOfStore() {
        LOGGER.info("Writing First Condition Of Store to file");
        String shopsToJson = gson.toJson(startCoffeeConditionList);
        try (FileWriter writer = new FileWriter(new File(FIRST_CONDITION_COFFEE_IN_STORE))) {
            writer.write(shopsToJson);
        } catch (IOException e) {
            LOGGER.error("IllegalState exception, cause file won't be found");
            throw new IllegalStateException(e);
        }
    }

    public List<Coffee> readFirstConditionOfStore() {
        LOGGER.info("Reading First Condition Of Store from file");
        try (JsonReader jsonReader = new JsonReader(new FileReader(FIRST_CONDITION_COFFEE_IN_STORE))) {
            Type type = new TypeToken<List<Coffee>>() {
            }.getType();
            return gson.fromJson(jsonReader, type);
        } catch (IOException e) {
            LOGGER.error("IllegalState exception, cause file won't be found");
            throw new IllegalStateException();
        }
    }
}
