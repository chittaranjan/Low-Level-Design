package org.example.designPrinciples.encapsulation;

import java.util.List;

/**
 * Identify the aspects of your application that vary
 * and separate them from what stays the same.
 *
 *
 * Goal : Minimize the effect caused by the change
 */
public class Encapsulation {

    class LineItem {
        private double price;
        private double quantity;
    }

    enum COUNTRY {
        US,
        EU,
        INDIA
    }
    class Order {
        private List<LineItem> lineItems;
        private COUNTRY country;
    }

    /**
     * Method to get total price of the order
     * @param order
     * @return
     */
    private double getOrderTotal(Order order) {
        double total = 0;
        for (LineItem item : order.lineItems) {
            total += item.price * item.quantity;
        }


        return total;
    }

    /**
     * Tax related can be complex and might needs to change in future
     * Need to refactor the tax rate calculation to separate method.
     * @param order
     * @return
     */

    private double getOrderTotalWithMethodEncapsulation(Order order) {
        double total = 0;
        for (LineItem item : order.lineItems) {
            total += item.price * item.quantity;
        }
        total += total * getTaxRate(order.country);
        return total;
    }

    private double getTaxRate(COUNTRY country) {
        if (country == COUNTRY.US) {
            return 0.07; // US sales tax
        } else if (country == COUNTRY.EU) {
            return 0.20; //European Union VAT
        } else if (country == COUNTRY.INDIA) {
            return 0.30; //India VAT
        }
        throw new IllegalArgumentException(country + "not supported.");
    }


    /**
     * If the tax calculation logic gets more complex
     * it makes sense to refactor the tax calculation out to a new class
     * @param order
     * @return
     */
    private double getOrderTotalWithClassEncapsulation(Order order) {
        double total = 0;
        for (LineItem item : order.lineItems) {
            total += item.price * item.quantity;
        }
        TaxCalculator taxCalculator = new TaxRateCalculatorImpl();
        total += total * taxCalculator.getTaxRate(order);
        return total;
    }
    interface TaxCalculator {
        double getTaxRate(Order order);
    }

    class TaxRateCalculatorImpl implements TaxCalculator {

        @Override
        public double getTaxRate(Order order) {
            return 0.0;
        }

        private double getUSTax() {
            return 0.0;
        }

        private double getEUTax() {
            return 0.0;
        }

        private double getIndiaTax() {
            return 0.0;
        }
    }

}
