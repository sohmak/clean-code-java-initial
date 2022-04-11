package com.thoughtworks.movierental;

public class Statement {


    public static String generateStatement(String name, Rentals rentals ) {
        StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");
        for (Rental each : rentals) {
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(each.amountFor()).append("\n");

        }
        result.append("Amount owed is ").append(rentals.getTotalAmount()).append("\n");
        result.append("You earned ").append(rentals.getTotalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }

    public static String generateHtmlStatement(String name, Rentals rentals) {
        StringBuilder result = new StringBuilder("<h1>Rental Record for <b>" + name + "</b></h1>");
        result.append("<p>");
        for (Rental each : rentals) {
            result.append(each.getMovie().getTitle()).append(": <b>").append(each.amountFor()).append("</b><br/>");

        }
        result.append("</p>");
        result.append("<p>Amount owed is <b> ").append(rentals.getTotalAmount()).append("</b></p></br>");
        result.append("<p>You earned <b>").append(rentals.getTotalFrequentRenterPoints()).append("</b> frequent renter points </p></br>");
        return result.toString();
    }

}
