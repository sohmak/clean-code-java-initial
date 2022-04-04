package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void shouldGenerateStatement() {

        Customer customer = new Customer("Loreena");
        customer.addRental(new Rental(new Movie("Star war1", 2), 4));
        customer.addRental(new Rental(new Movie("Star war2", 2), 4));
        customer.addRental(new Rental(new Movie("Star war3", 2), 4));

        String expect = "Rental Record for Loreena\n" +
                "\tStar war1\t3.0\n" +
                "\tStar war2\t3.0\n" +
                "\tStar war3\t3.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 3 frequent renter points";

        String statement = customer.statement();
        Assert.assertEquals(expect, statement);
    }

    @Test
    public void shouldGenerateHTMLStatement() {

        Customer customer = new Customer("Loreena");
        customer.addRental(new Rental(new Movie("Star war1", 2), 4));
        customer.addRental(new Rental(new Movie("Star war2", 2), 4));
        customer.addRental(new Rental(new Movie("Star war3", 2), 4));

        String expect = "<h1>Rental Record for <b>Loreena</b></h1>" +
                "<p>" +
                "Star war1: <b>3.0</b><br/>" +
                "Star war2: <b>3.0</b><br/>" +
                "Star war3: <b>3.0</b><br/>" +
                "</p><p>Amount owed is <b> 9.0</b></p></br>" +
                "<p>You earned <b>3</b> frequent renter points </p></br>";

        String htmlstatement = customer.htmlStatement();
        Assert.assertEquals(expect, htmlstatement);
    }

}