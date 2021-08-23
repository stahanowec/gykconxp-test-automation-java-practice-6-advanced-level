package com.epam.test.automation.java.practice6;

import java.math.BigDecimal;

public class Manager extends Employee {
    private int quantity;

    public Manager(String name, BigDecimal salary, int clientAmount) {
        super(name, salary);
        this.quantity = clientAmount;
    }

    @Override
    public void setBonus(BigDecimal bonus) {
        validateBonus(bonus);
        if (quantity > 150) {
            bonus = bonus.add(new BigDecimal(1000));
        } else if (quantity > 100) {
            bonus = bonus.add(new BigDecimal(500));
        }
        super.updateBonus(bonus);
    }
}