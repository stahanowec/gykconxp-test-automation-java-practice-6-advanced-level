package com.epam.test.automation.java.practice6;

import java.math.BigDecimal;

public class SalesPerson extends Employee {

    private int percent;

    public SalesPerson(String name, BigDecimal salary, int bonus) {
        super(name, salary);
        this.percent = bonus;
    }

    @Override
    public void setBonus(BigDecimal bonus) {
        validateBonus(bonus);
        if (percent > 200) {
            bonus = bonus.multiply(new BigDecimal(3));
        } else if (percent > 100) {
            bonus = bonus.multiply(new BigDecimal(2));
        }
        super.updateBonus(bonus);
    }
}