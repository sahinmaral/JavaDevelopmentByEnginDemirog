package Entities;

import Abstract.Entity;

public class Game implements Entity {
    private int id;
    private double Price;
    private String Type;
    private String Name;

    public Game(int id, double price, String type, String name) {
        this.id = id;
        Price = price;
        Type = type;
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
