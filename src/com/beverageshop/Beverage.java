package com.beverageshop;

/*
 * Class: CMSC203
 * Instructor:
 * Description: Abstract class representing a general beverage.
 * Due: MM/DD/YYYY
 * Platform/compiler: Java SE
 * I pledge that I have completed the programming independently.
 * Print your Name here: __________
 */
public abstract class Beverage {
    private String name;
    private Type type;
    private Size size;
    protected static final double BASE_PRICE = 2.0;
    protected static final double SIZE_PRICE = 0.5;

    public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public abstract double calcPrice();

    public double addSizePrice() {
        switch (size) {
            case MEDIUM: return BASE_PRICE + SIZE_PRICE;
            case LARGE: return BASE_PRICE + 2 * SIZE_PRICE;
            default: return BASE_PRICE;
        }
    }

    @Override
    public String toString() {
        return name + " (" + size + ")";
    }

    public boolean equals(Beverage other) {
        return name.equals(other.name) && type == other.type && size == other.size;
    }

    public String getName() { return name; }
    public Size getSize() { return size; }
    public Type getType() { return type; }
}
