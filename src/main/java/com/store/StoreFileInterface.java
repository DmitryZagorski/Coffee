package com.store;

import com.coffee.Coffee;

import java.util.List;

public interface StoreFileInterface {

    void writeFirstConditionOfStore();

    List<Coffee> readFirstConditionOfStore();

}
