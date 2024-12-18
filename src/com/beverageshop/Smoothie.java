package com.beverageshop;

public class Smoothie extends Beverage {
    private int numFruits;
    private boolean addProtein;
    private static final double FRUIT_COST = 0.5;
    private static final double PROTEIN_COST = 1.5;

    public Smoothie(String name, Size size, int numFruits, boolean addProtein) {
        super(name, Type.SMOOTHIE, size);
        this.numFruits = numFruits;
        this.addProtein = addProtein;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice() + numFruits * FRUIT_COST;
        if (addProtein) price += PROTEIN_COST;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fruits: " + numFruits + ", Protein: " + addProtein + ", Price: $" + calcPrice();
    }
}
