package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void test() {

        int expected = 3;

        Assert.assertEquals(expected, 1 + 2);
    }

    @Test
    public void statementTest() {
        Customer jimmy = new Customer("Jimmy");
        jimmy.addRental(new Rental(new Movie("Inception", 0), 2));
        jimmy.addRental(new Rental(new Movie("Whiplash", 1), 2));
        jimmy.addRental(new Rental(new Movie("Titanic", 1), 3));

        String expected = jimmy.statement();

        Assert.assertEquals(expected, "Rental Record for Jimmy\n" +
                "\tInception\t2.0\n" +
                "\tWhiplash\t6.0\n" +
                "\tTitanic\t9.0\n" +
                "Amount owed is 17.0\n" +
                "You earned 5 frequent renter points");


    }


}