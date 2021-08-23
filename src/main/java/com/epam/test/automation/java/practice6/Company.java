package com.epam.test.automation.java.practice6;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class Company {

    private Employee[] staff; //Closed field employees (staff) an array of Employee type

    public Company(Employee[] employeeArray) { //Constructor that receives employee array of Employee type with arbitrary length
        this.staff = employeeArray;
    }

    public void giveEverybodyBonus(BigDecimal companyBonus) {  //Method with money parameter companyBonus that sets the amount of basic bonus for each employee
        Arrays.stream(staff).forEach(updateBonus(companyBonus));
    }

    public BigDecimal totalToPay() { //returns total amount of salary of all employees including awarded bonus
        return Arrays.stream(staff).map(Employee::toPay).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String nameMaxSalary() { //returns employee last name, who received maximum salary including bonus.
        return Arrays.stream(staff).map(Pair::new).max(Comparator.comparing(Pair::getSalary)).map(Pair::getName)
                .orElseThrow(IllegalArgumentException::new);
    }


    private Consumer<Employee> updateBonus(BigDecimal bonus) {
        return employee -> employee.setBonus(bonus);
    }

    public static class Pair {
        private String name;
        private BigDecimal salary;

        public Pair(Employee employee) {
            this.name = employee.getName();
            this.salary = employee.toPay();
        }

        public String getName() {
            return name;
        }

        public BigDecimal getSalary() {
            return salary;
        }
    }

}
