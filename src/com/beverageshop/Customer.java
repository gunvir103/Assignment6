package com.beverageshop;

public class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer(Customer other) {
        this.name = other.name;
        this.age = other.age;
    }

    public String toString() {
        return name + ", Age: " + age;
    }

    public int getAge() { return age; }
    public String getName() { return name; }
}
