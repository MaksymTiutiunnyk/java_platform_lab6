package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TariffSetTest {

    private TariffSet tariffSet;
    private Tariff t1;
    private Tariff t2;
    private Tariff t3;

    @BeforeEach
    void setUp() {
        t1 = new BasicTariff("Basic", 100, 1000);
        t2 = new FamilyTariff("Family", 200, 500);
        t3 = new PremiumTariff("Premium", 300, 300);
        tariffSet = new TariffSet();
    }

    @Test
    void testAdd() {
        assertTrue(tariffSet.add(t1));
        assertTrue(tariffSet.add(t2));
        assertFalse(tariffSet.add(t1));
        assertEquals(2, tariffSet.size());
    }

    @Test
    void testRemove() {
        tariffSet.add(t1);
        tariffSet.add(t2);
        assertTrue(tariffSet.remove(t1));
        assertFalse(tariffSet.contains(t1));
        assertEquals(1, tariffSet.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(tariffSet.isEmpty());
        tariffSet.add(t1);
        assertFalse(tariffSet.isEmpty());
    }

    @Test
    void testContains() {
        tariffSet.add(t1);
        assertTrue(tariffSet.contains(t1));
        assertFalse(tariffSet.contains(t2));
    }

    @Test
    void testAddAll() {
        List<Tariff> tariffs = Arrays.asList(t1, t2, t3);
        assertTrue(tariffSet.addAll(tariffs));
        assertEquals(3, tariffSet.size());
    }

    @Test
    void testRetainAll() {
        tariffSet.add(t1);
        tariffSet.add(t2);
        List<Tariff> tariffsToRetain = Collections.singletonList(t1);
        assertTrue(tariffSet.retainAll(tariffsToRetain));
        assertFalse(tariffSet.contains(t2));
        assertEquals(1, tariffSet.size());
    }

    @Test
    void testRemoveAll() {
        tariffSet.add(t1);
        tariffSet.add(t2);
        tariffSet.add(t3);
        List<Tariff> tariffsToRemove = Arrays.asList(t1, t3);
        assertTrue(tariffSet.removeAll(tariffsToRemove));
        assertFalse(tariffSet.contains(t1));
        assertFalse(tariffSet.contains(t3));
        assertTrue(tariffSet.contains(t2));
        assertEquals(1, tariffSet.size());
    }

    @Test
    void testContainsAll() {
        tariffSet.add(t1);
        tariffSet.add(t2);
        List<Tariff> tariffsToCheck = Arrays.asList(t1, t2);
        assertTrue(tariffSet.containsAll(tariffsToCheck));

        tariffsToCheck = Arrays.asList(t1, t2, t3);
        assertFalse(tariffSet.containsAll(tariffsToCheck));
    }

    @Test
    void testClear() {
        tariffSet.add(t1);
        tariffSet.add(t2);
        tariffSet.clear();
        assertEquals(0, tariffSet.size());
        assertTrue(tariffSet.isEmpty());
    }

    @Test
    void testToArray() {
        tariffSet.add(t1);
        tariffSet.add(t2);
        Object[] tariffs = tariffSet.toArray();
        assertEquals(2, tariffs.length);
        assertEquals(t1, tariffs[0]);
        assertEquals(t2, tariffs[1]);
    }

    @Test
    void testToArrayWithSpecifiedArray() {
        tariffSet.add(t1);
        tariffSet.add(t2);
        Tariff[] array = new Tariff[2];
        array = tariffSet.toArray(array);

        assertEquals(2, array.length);
        assertEquals(t1, array[0]);
        assertEquals(t2, array[1]);
    }

    @Test
    void testToArrayWithLargerArray() {
        tariffSet.add(t1);
        tariffSet.add(t2);
        Tariff[] array = new Tariff[5];
        array = tariffSet.toArray(array);

        assertEquals(5, array.length);
        assertEquals(t1, array[0]);
        assertEquals(t2, array[1]);
        assertNull(array[2]);
    }

    @Test
    void testSize() {
        assertEquals(0, tariffSet.size());
        tariffSet.add(t1);
        assertEquals(1, tariffSet.size());
        tariffSet.add(t2);
        assertEquals(2, tariffSet.size());
    }
}
