package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Class representing a mobile company that manages a set of tariffs.
 */
public class MobileCompany {
    private final TariffSet tariffs;

    /**
     * Constructor for creating a mobile company with a set of tariffs.
     *
     * @param tariffs set of tariffs
     */
    public MobileCompany(TariffSet tariffs) {
        this.tariffs = tariffs;
    }

    /**
     * Gets tariffs of the mobile company.
     *
     * @return the tariffs of the mobile company
     */
    public TariffSet getTariffs() {
        return tariffs;
    }

    /**
     * Calculates the total number of clients subscribed to all tariffs.
     *
     * @return the total number of clients
     */
    public int calculateTotalClients() {
        return tariffs.stream().mapToInt(Tariff::getNumberOfClients).sum();
    }

    /**
     * Sorts the set of tariffs by their monthly fee in ascending order.
     * Since the underlying structure is a set, it cannot be sorted directly.
     * So, we convert it to an array for sorting purposes.
     */
    public void sortTariffsByMonthlyFee() {
        Tariff[] sortedTariffs = tariffs.toArray(new Tariff[0]);
        Arrays.sort(sortedTariffs, Comparator.comparingDouble(Tariff::getMonthlyFee));
        tariffs.clear();
        tariffs.addAll(Arrays.asList(sortedTariffs));
    }

    /**
     * Finds tariffs within a given monthly fee range.
     *
     * @param minFee minimum fee value
     * @param maxFee maximum fee value
     * @return array of tariffs within the fee range
     */
    public Tariff[] findTariffByFeeRange(double minFee, double maxFee) {
        return tariffs.stream()
                .filter(tariff -> tariff.getMonthlyFee() >= minFee && tariff.getMonthlyFee() <= maxFee)
                .toArray(Tariff[]::new);
    }

    /**
     * Prints all tariffs to the console.
     */
    public void printTariffs() {
        tariffs.forEach(System.out::println);
    }

    /**
     * Prints the provided array of tariffs to the console.
     *
     * @param tariffs array of tariffs to print
     */
    public void printTariffs(Tariff[] tariffs) {
        for (Tariff tariff : tariffs)
            System.out.println(tariff);
    }
}
