package com.thoughtworks.movierental;


public class Customer {
    private final String name;
    private final Rentals rentals = new Rentals();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String statement() {
        return Statement.generateStatement(getName(), rentals);
    }

    public String htmlStatement() {
        return Statement.generateHtmlStatement(getName(), rentals);
    }

    public String getName() {
        return name;
    }

}

