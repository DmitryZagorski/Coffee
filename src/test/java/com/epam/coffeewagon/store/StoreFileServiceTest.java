package com.epam.coffeewagon.store;

import com.epam.coffeewagon.coffee.Coffee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class StoreFileServiceTest {

    private static final String FIRST_CONDITION_COFFEE_IN_STORE = "D:/java/Coffee/src/main/java/com/epam/coffeewagon/store/FirstCoffeeListInStore.txt";

    @Test
    void writeFirstConditionOfStore() {
        StoreFileInterface storeFileInterface = new StoreFileService();
        File file = new File(FIRST_CONDITION_COFFEE_IN_STORE);
        long firstLength = file.length();
        storeFileInterface.writeFirstConditionOfStore();
        long secondLength = file.length();

        Assert.assertNotEquals(firstLength, secondLength);

    }

    @Test
    void readFirstConditionOfStore() {
        StoreFileInterface storeFileInterface = new StoreFileService();
        List<Coffee> list = new ArrayList<>();
        list = storeFileInterface.readFirstConditionOfStore();

        String seventhName = "Dallmayr";

        Assert.assertEquals(seventhName, list.get(6).getName());
        Assert.assertEquals(12, list.size());

    }
}