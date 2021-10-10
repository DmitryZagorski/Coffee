package com.epam.coffeewagon.store;

import com.epam.coffeewagon.coffee.Coffee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class StoreFileServiceTest {

    private static final String FIRST_CONDITION_COFFEE_IN_STORE = ".\\src\\main\\java\\com\\epam\\coffeewagon\\store\\FirstCoffeeListInStore.gson";

    @Test
    void should_write_first_condition_of_store_in_our_file() {
        StoreFileInterface storeFileInterface = new StoreFileService();
        File file = new File(FIRST_CONDITION_COFFEE_IN_STORE);
        long firstLength = file.length();
        storeFileInterface.writeFirstConditionOfStore();
        File file1 = file; //?
        long secondLength = file.length();

        Assert.assertNotSame(file, file1);//?

    //    Assert.assertNotEquals(firstLength, secondLength);

    }

    @Test
    void should_read_first_condition_of_store_from_our_file() {
        StoreFileInterface storeFileInterface = new StoreFileService();
        List<Coffee> list;
        list = storeFileInterface.readFirstConditionOfStore();

        String seventhName = "Dallmayr";

        Assert.assertEquals(seventhName, list.get(6).getName());
        Assert.assertEquals(12, list.size());

    }
}