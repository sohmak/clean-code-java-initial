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
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    each.amountFor() + "\n";

        }
        result += "Amount owed is " + getTotalAmount() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints()
                + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        String result = "<h1>Rental Record for <b>" + getName() + "</b></h1>";
        result += "<p>";
        for (Rental each : rentals) {
            result +=  each.getMovie().getTitle() + ": <b>" +
                    each.amountFor() + "</b><br/>";

        }
        result += "</p>";
        result += "<p>Amount owed is <b> " + getTotalAmount() + "</b></p></br>";
        result += "<p>You earned <b>" + getTotalFrequentRenterPoints()
                + "</b> frequent renter points </p></br>";
        return result;
    }


    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental each : rentals) {
            totalAmount += each.amountFor();
        }
        return totalAmount;
    }

    private int getTotalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        for (Rental rental : rentals) {
            totalFrequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }

}

