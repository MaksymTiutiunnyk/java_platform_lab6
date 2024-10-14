package org.example;

/**
 * Class representing a family tariff plan.
 */
public class FamilyTariff extends Tariff {

    /**
     * Constructor for creating a family tariff.
     *
     * @param name          the name of the tariff
     * @param monthlyFee    the monthly fee for the tariff
     * @param numberOfClients the number of clients subscribed to the tariff
     */
    public FamilyTariff(String name, int monthlyFee, int numberOfClients) {
        super(name, monthlyFee, numberOfClients);
    }

    /**
     * Returns a string representation of the family tariff.
     *
     * @return formatted string describing the family tariff
     */
    @Override
    public String toString() {
        return String.format("Family tariff: " + name + ", Monthly Fee: " + monthlyFee + ", Clients: " + numberOfClients);
    }
}
