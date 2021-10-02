package com.store;

import com.coffee.Coffee;
import com.coffee.condition.Condition;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StoreFileService implements StoreFileInterface {

    private static final String FIRST_CONDITION_COFFEE_IN_STORE = "D:/java/Coffee/src/main/java/com/store/FirstCoffeeListInStore.txt";

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
        try {
            FileOutputStream fos = new FileOutputStream(FIRST_CONDITION_COFFEE_IN_STORE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(startCoffeeConditionList);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Coffee> readFirstConditionOfStore() {
        List<Coffee> firstConditionalList = new ArrayList<>();
       /* try{
            FileInputStream fis = new FileInputStream(FIRST_CONDITION_COFFEE_IN_STORE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            firstConditionalList = (List<Coffee>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        firstConditionalList = startCoffeeConditionList;
        return firstConditionalList;
    }
}
