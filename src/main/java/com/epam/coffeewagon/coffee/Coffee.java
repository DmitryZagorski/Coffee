package com.epam.coffeewagon.coffee;

import com.epam.coffeewagon.coffee.condition.Condition;
import java.io.Serializable;

public class Coffee implements Serializable {

    static final long serialVersionUID = -5843571478875457590L;

    private final String name;
    private Condition condition;
    private double capacity;
    private double weight;
    private double price;

    public Coffee(String name, Condition condition, double capacity, double weight, double price) {
        this.name = name;
        this.condition = condition;
        this.capacity = capacity;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceToWeight() {
        return price / weight;
    }

    @Override
    public String toString() {
        return "Coffee {" +
                "name = '" + name + '\'' +
                ", condition = " + condition +
                ", capacity = " + capacity +
                ", weight = " + weight +
                ", price = " + price +
                '}';
    }
}
