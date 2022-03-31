package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int totalFrequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            double rentalAmount = each.amount();

            result = getRentalResult(result, each, rentalAmount);

            totalAmount += rentalAmount;
            totalFrequentRenterPoints += each.frequentRenterPoints();
        }

        //add footer lines result
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoints
                + " frequent renter points";
        return result;
    }

    public String getRentalResult(String result, Rental each, double rentalAmount) {
        result += "\t" + each.getMovie().getTitle() + "\t" +
                rentalAmount + "\n";
        return result;
    }

}

