package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {

    double getTotalAmount() {
        return this.stream().mapToDouble(Rental::amountFor).sum();
    }

    int getTotalFrequentRenterPoints() {
        return this.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }
}