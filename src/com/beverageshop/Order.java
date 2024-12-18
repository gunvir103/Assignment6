package com.beverageshop;

import java.util.ArrayList;

public class Order {
    private Customer customer;
    private Day day;
    private ArrayList<Beverage> beverages;

    public Order(Customer customer, Day day) {
        this.customer = new Customer(customer); // Deep copy of customer
        this.day = day;
        this.beverages = new ArrayList<>(); // Initialize beverage list
    }

    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, day == Day.SATURDAY || day == Day.SUNDAY));
    }

    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    public double calcOrderTotal() {
        double total = 0;
        for (Beverage beverage : beverages) {
            total += beverage.calcPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customer.toString()).append(", Day: ").append(day).append("\n");
        for (Beverage beverage : beverages) {
            sb.append(beverage.toString()).append("\n");
        }
        sb.append("Total: $").append(calcOrderTotal());
        return sb.toString();
    }
}
