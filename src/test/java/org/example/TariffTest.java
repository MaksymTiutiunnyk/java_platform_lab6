package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TariffTest {

    @Test
    void testBasicTariffToString() {
        Tariff basicTariff = new BasicTariff("Basic Plan", 90, 10000);
        String expected = "Basic tariff: Basic Plan, Monthly Fee: 90, Clients: 10000";
        assertEquals(expected, basicTariff.toString(), "BasicTariff toString() output is incorrect");
    }

    @Test
    void testFamilyTariffToString() {
        Tariff familyTariff = new FamilyTariff("Family Plan", 200, 50000);
        String expected = "Family tariff: Family Plan, Monthly Fee: 200, Clients: 50000";
        assertEquals(expected, familyTariff.toString(), "FamilyTariff toString() output is incorrect");
    }

    @Test
    void testPremiumTariffToString() {
        Tariff premiumTariff = new PremiumTariff("Premium Plan", 300, 20000);
        String expected = "Premium tariff: Premium Plan, Monthly Fee: 300, Clients: 20000";
        assertEquals(expected, premiumTariff.toString(), "PremiumTariff toString() output is incorrect");
    }
}
