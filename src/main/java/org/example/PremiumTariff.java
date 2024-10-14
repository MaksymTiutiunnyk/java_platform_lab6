package org.example;

/**
 * Class representing a premium tariff plan.
 */
public class PremiumTariff extends Tariff {

    /**
     * Constructor for creating a premium tariff.
     *
     * @param name          the name of the tariff
     * @param monthlyFee    the monthly fee for the tariff
     * @param numberOfClients the number of clients subscribed to the tariff
     */
    public PremiumTariff(String name, int monthlyFee, int numberOfClients) {
        super(name, monthlyFee, numberOfClients);
    }

    /**
     * Returns a string representation of the premium tariff.
     *
     * @return formatted string describing the premium tariff
     */
    @Override
    public String toString() {
        return String.format("Premium tariff: " + name + ", Monthly Fee: " + monthlyFee + ", Clients: " + numberOfClients);
    }
}
