// 23 варіант, C13 = 10

package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    /**
     * Array of tariffs offered by the mobile company.
     */
    private static final Tariff[] TARIFFS = {
            new BasicTariff("Basic Plan", 90, 10000),
            new BasicTariff("Basic+ Plan", 120, 50000),
            new BasicTariff("Standard Plan", 150, 200000),
            new FamilyTariff("Family-2 Plan", 220, 170000),
            new FamilyTariff("Family-3 Plan", 320, 150000),
            new FamilyTariff("Family-4 Plan", 420, 100000),
            new FamilyTariff("Family-5+ Plan", 520, 10000),
            new PremiumTariff("Premium Plan", 300, 50000),
            new PremiumTariff("Max Premium Plan", 400, 10000),
    };

    /**
     * Minimum fee for finding tariffs within a specified range.
     */
    private static final int MIN_FEE = 150;

    /**
     * Maximum fee for finding tariffs within a specified range.
     */
    private static final int MAX_FEE = 250;

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        TariffSet tariffSet = new TariffSet(Arrays.asList(TARIFFS));

        MobileCompany mobileCompany = new MobileCompany(tariffSet);

        System.out.println("Tariffs before sorting:");
        mobileCompany.printTariffs();

        Tariff[] sortedTariffs = mobileCompany.getTariffs().toArray(new Tariff[0]);
        Arrays.sort(sortedTariffs, Comparator.comparingDouble(Tariff::getMonthlyFee));

        System.out.println("\nTariffs after sorting by monthly fee:");
        mobileCompany.printTariffs(sortedTariffs);

        System.out.println("\nTotal number of clients: " + mobileCompany.calculateTotalClients());

        System.out.println("\nFound tariffs in range 150 - 250 hryvnias:");
        Tariff[] foundTariffs = mobileCompany.findTariffByFeeRange(MIN_FEE, MAX_FEE);
        if (foundTariffs.length > 0)
            mobileCompany.printTariffs(foundTariffs);
        else
            System.out.println("No tariffs found");
    }
}
