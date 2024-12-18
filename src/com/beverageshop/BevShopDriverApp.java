package com.beverageshop;

public class BevShopDriverApp {
    public static void main(String[] args) {
        BevShop shop = new BevShop();

        try {
            // Start a new order
            shop.startNewOrder(10, Day.SATURDAY, "John", 25);

            // Add beverages to the order
            shop.processCoffeeOrder("Cappuccino", Size.LARGE, true, false);
            shop.processAlcoholOrder("Whiskey", Size.SMALL);
            shop.processSmoothieOrder("Berry Smoothie", Size.MEDIUM, 4, true);

            // Print current order details
            System.out.println("Order Details: ");
            System.out.println(shop.getCurrentOrder());

            // Print total monthly sales
            System.out.println("\nTotal Monthly Sale: $" + shop.totalMonthlySale());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
