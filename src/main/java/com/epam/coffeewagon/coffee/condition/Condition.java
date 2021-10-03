package com.epam.coffeewagon.coffee.condition;

public enum Condition {

    BEANS("BeansCoffee"),
    GROUND("GroundCoffee"),
    INSTANT_BAGS("InstantCoffeeInBags"),
    INSTANT_CANS("InstantCoffeeInCans");

    private String conditionName;

    Condition(String conditionName) {
        this.conditionName = conditionName;
    }
}
