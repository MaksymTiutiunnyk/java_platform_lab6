package org.example;

/**
 * Class representing a basic tariff plan.
 */
public class BasicTariff extends Tariff {

    /**
     * Constructor for creating a basic tariff.
     *
     * @param name          the name of the tariff
     * @param monthlyFee    the monthly fee for the tariff
     * @param numberOfClients the number of clients subscribed to the tariff
     */
    public BasicTariff(String name, int monthlyFee, int numberOfClients) {
        super(name, monthlyFee, numberOfClients);
    }

    /**
     * Returns a string representation of the basic tariff.
     *
     * @return formatted string describing the basic tariff
     */
    @Override
    public String toString() {
        return String.format("Basic tariff: " + name + ", Monthly Fee: " + monthlyFee + ", Clients: " + numberOfClients);
    }
}
