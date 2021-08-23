package com.epam.test.automation.java.practice6;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;

public class CompanyTest {


    @Test
    public void ifCountThenSucess() {
        // given
        var manager = getManager("Nick");
        var salesPerson = getSalesPerson("Some");
        var employees = new Employee[]{manager, salesPerson};
        //when
        var company = new Company(employees);
        company.giveEverybodyBonus(new BigDecimal(10));
        var totalToPay = company.totalToPay();
        var nameMaxSalary = company.nameMaxSalary();
        //then
        assertEquals(new BigDecimal(8020), totalToPay);
        assertEquals(manager.getName(), nameMaxSalary);
    }



    private Manager getManager(String name) {
        return new Manager(name, new BigDecimal(5000), new Random(20).nextInt());
    }

    private SalesPerson getSalesPerson(String name) {
        return new SalesPerson(name, new BigDecimal(3000), 20);
    }

}
