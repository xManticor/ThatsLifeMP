package model;

public class SalaryCard extends Card {
    String type = "Salary";
    int salary;
    int taxDue;
    int payRaise;

    public SalaryCard(String name, int salary, int taxDue) {
        super(name);
        this.taxDue = taxDue;
        this.salary = salary;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getTaxDue() {
        return this.taxDue;
    }

    public int getPayRaise() {
        return this.payRaise;
    }

    public void increaseSalary(double amount) {
        this.salary += amount;
    }
}