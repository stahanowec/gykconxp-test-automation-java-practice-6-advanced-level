package com.epam.test.automation.java.practice6;

import org.testng.annotations.Test;

import java.math.BigDecimal;

public class ManagerTest {
    @Test
    public void testName() {
        var bigDecimal = new BigDecimal(-1);
        System.out.println(bigDecimal.compareTo(new BigDecimal(0)) <= 0);
    }
}
