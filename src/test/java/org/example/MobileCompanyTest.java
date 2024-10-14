package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MobileCompanyTest {
    private MobileCompany company;

    @BeforeEach
    void setUp() {
        Tariff[] tariffs = {
                new BasicTariff("Basic Plan", 90, 10000),
                new FamilyTariff("Family Plan", 200, 50000),
                new PremiumTariff("Premium Plan", 300, 20000)
        };
        company = new MobileCompany(new TariffSet(Arrays.asList(tariffs)));
    }

    @Test
    void testCalculateTotalClients() {
        int totalClients = company.calculateTotalClients();
        assertEquals(80000, totalClients, "Total clients should be 80000");
    }

    @Test
    void testSortTariffsByMonthlyFee() {
        company.sortTariffsByMonthlyFee();
        Tariff[] sortedTariffs = company.findTariffByFeeRange(0, 1000);
        assertEquals(90.0, sortedTariffs[0].getMonthlyFee(), "The first tariff should have the lowest monthly fee");
        assertEquals(200.0, sortedTariffs[1].getMonthlyFee(), "The second tariff should have the second lowest monthly fee");
        assertEquals(300.0, sortedTariffs[2].getMonthlyFee(), "The last tariff should have the highest monthly fee");
    }

    @Test
    void testFindTariffByFeeRange() {
        Tariff[] foundTariffs = company.findTariffByFeeRange(100, 250);
        assertEquals(1, foundTariffs.length, "Only one tariff should be found in the fee range 100-250");
        assertEquals("Family Plan", foundTariffs[0].name, "The found tariff should be 'Family Plan'");
    }
}


