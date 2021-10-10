package com.epam.coffeewagon.store;

import com.epam.coffeewagon.coffee.Coffee;
import java.util.List;

public interface StoreFileInterface {

    void writeFirstConditionOfStore();

    List<Coffee> readFirstConditionOfStore();
}
