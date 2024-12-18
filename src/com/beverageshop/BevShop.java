package com.beverageshop;

import java.util.ArrayList;

public class BevShop implements BevShopInterface {
    private ArrayList<Order> orders; // List of all orders
    private Order currentOrder;      // Current order being processed
    private int numOfAlcoholDrinks;  // Alcohol drink counter for the current order

    public BevShop() {
        orders = new ArrayList<>();
        currentOrder = null;
        numOfAlcoholDrinks = 0;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        if (isValidTime(time)) {
            Customer customer = new Customer(customerName, customerAge);
            currentOrder = new Order(customer, day);
            orders.add(currentOrder);
            numOfAlcoholDrinks = 0; // Reset alcohol count for the new order
        } else {
            throw new IllegalArgumentException("Invalid time for order. Must be between 8 AM and 11 PM.");
        }
    }

    @Override
    public Order getCurrentOrder() {
        return currentOrder; // Return the current order
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        if (currentOrder != null) {
            currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
        } else {
            throw new IllegalStateException("No current order to process beverages.");
        }
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (currentOrder != null) {
            if (numOfAlcoholDrinks < getMaxOrderForAlcohol()) {
                currentOrder.addNewBeverage(bevName, size);
                numOfAlcoholDrinks++;
            } else {
                System.out.println("Maximum alcohol drinks reached for this order.");
            }
        } else {
            throw new IllegalStateException("No current order to process beverages.");
        }
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (currentOrder != null) {
            if (!isMaxFruit(numOfFruits)) {
                currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
            } else {
                System.out.println("Maximum fruits allowed exceeded for this smoothie.");
            }
        } else {
            throw new IllegalStateException("No current order to process beverages.");
        }
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }
}
