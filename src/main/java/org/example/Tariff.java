package org.example;

/**
 * Abstract base class representing a mobile tariff plan.
 */
public abstract class Tariff {
    protected String name;
    protected int monthlyFee;
    protected int numberOfClients;

    /**
     * Constructor for creating a tariff plan.
     *
     * @param name          the name of the tariff
     * @param monthlyFee    the monthly fee for the tariff
     * @param numberOfClients the number of clients subscribed to the tariff
     */
    public Tariff(String name, int monthlyFee, int numberOfClients) {
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.numberOfClients = numberOfClients;
    }

    /**
     * Gets the monthly fee for the tariff.
     *
     * @return the monthly fee
     */
    public double getMonthlyFee() {
        return monthlyFee;
    }

    /**
     * Gets the number of clients subscribed to the tariff.
     *
     * @return the number of clients
     */
    public int getNumberOfClients() {
        return numberOfClients;
    }
}


