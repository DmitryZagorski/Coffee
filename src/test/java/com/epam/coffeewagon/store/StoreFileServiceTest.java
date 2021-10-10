package com.epam.coffeewagon.store;

import com.epam.coffeewagon.coffee.Coffee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.List;

class StoreFileServiceTest {

    private static final String FIRST_CONDITION_COFFEE_IN_STORE = "FirstCoffeeListInStore.json";

    @Test
    void should_write_first_condition_of_store_in_our_file() {
        // given
        StoreFileInterface storeFileInterface = new StoreFileService();
        File file = new File(FIRST_CONDITION_COFFEE_IN_STORE);
        // when
        storeFileInterface.writeFirstConditionOfStore();
        long secondLength = file.length();
        // then
        Assert.assertEquals(1010, secondLength);
    }

    @Test
    void should_read_first_condition_of_store_from_our_file() {
        // given
        StoreFileInterface storeFileInterface = new StoreFileService();
        List<Coffee> list;
        // when
        list = storeFileInterface.readFirstConditionOfStore();
        String seventhName = "Dallmayr";
        // then
        Assert.assertEquals(seventhName, list.get(6).getName());
        Assert.assertEquals(12, list.size());
    }
}